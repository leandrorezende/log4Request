package br.com.fortbit.logserver.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.fortbit.logserver.domain.WebRequestLogs;
import br.com.fortbit.logserver.dto.WebRequestLogsDTO;
import br.com.fortbit.logserver.repositories.WebRequestLogsRepository;
import br.com.fortbit.logserver.repositories.filters.WebRequestLogsFilter;
import br.com.fortbit.logserver.repositories.specifications.WebRequestLogsSpecification;
import br.com.fortbit.logserver.services.exceptions.DataIntegrityException;
import br.com.fortbit.logserver.services.exceptions.ObjectNotFoundException;

@Service
public class WebRequestLogService {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
	
	@Autowired
	private WebRequestLogsRepository repo;

	public WebRequestLogs find(Integer id) {
		Optional<WebRequestLogs> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + WebRequestLogs.class.getName()));
	}

	public WebRequestLogs insert(WebRequestLogs obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public WebRequestLogs update(WebRequestLogs obj) {
		WebRequestLogs newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public List<WebRequestLogs> findAll() {
		return repo.findAll();
	}

	public Page<WebRequestLogs> findPage(WebRequestLogsFilter filter, Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		WebRequestLogsSpecification spec = new WebRequestLogsSpecification(filter);
		return repo.findAll(spec, pageRequest);
	}

	public void insertBatch(MultipartFile file) {
		try {
			List<String> logRecordsRaw = new BufferedReader(new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8)).lines()
					.collect(Collectors.toList());
			List<WebRequestLogs> logRecords = logRecordsRaw.stream().limit(500).map(i -> fromPipeDelimiter(i.split("\\|"))).collect(Collectors.toList());
			repo.saveAll(logRecords);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public WebRequestLogs fromDTO(WebRequestLogsDTO objDTO) {
		return new WebRequestLogs(objDTO.getId(), objDTO.getData(), objDTO.getRequest(), objDTO.getIp(),
				objDTO.getStatus(), objDTO.getUserAgent());
	}
	
	private WebRequestLogs fromPipeDelimiter(String[] record) {
		WebRequestLogs log = new WebRequestLogs();
		log.setData(LocalDateTime.parse(record[0], formatter));
		log.setIp(record[1]);
		log.setRequest(record[2].substring(1, record[2].length()-1));
		log.setStatus(Integer.valueOf(record[3]));
		log.setUserAgent(record[4].substring(1, record[4].length()-1));
		return log;
	}

	private void updateData(WebRequestLogs newObj, WebRequestLogs obj) {
		newObj.setData(obj.getData());
		newObj.setRequest(obj.getRequest());
		newObj.setIp(obj.getIp());
		newObj.setStatus(obj.getStatus());
		newObj.setUserAgent(obj.getUserAgent());
	}
	
}
