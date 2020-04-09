package br.com.fortbit.logserver.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fortbit.logserver.domain.WebRequestLogs;
import br.com.fortbit.logserver.dto.WebRequestLogsDTO;
import br.com.fortbit.logserver.repositories.filters.WebRequestLogsFilter;
import br.com.fortbit.logserver.services.WebRequestLogService;

@RestController
@RequestMapping(value = "/webRequest")
public class WebRequestLogResource {
	
	@Autowired
	private WebRequestLogService service;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<WebRequestLogsDTO>> findAll() {
		List<WebRequestLogs> list = service.findAll();
		List<WebRequestLogsDTO> listDto = list.stream().map(obj -> new WebRequestLogsDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin
	@GetMapping(value = "/{id}")
	public ResponseEntity<WebRequestLogs> find(@PathVariable Integer id) {
		WebRequestLogs obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody WebRequestLogsDTO objDTO) {
		WebRequestLogs obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@PutMapping(value = "/{id}")
	public ResponseEntity<WebRequestLogs> update(@Valid @RequestBody WebRequestLogsDTO objDTO, @PathVariable Integer id) {
		WebRequestLogs obj = service.fromDTO(objDTO);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@PostMapping(value = "/page")
	public ResponseEntity<Page<WebRequestLogsDTO>> findPage(
			@RequestBody WebRequestLogsFilter filter,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "id") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<WebRequestLogs> list = service.findPage(filter, page, linesPerPage, orderBy, direction);
		Page<WebRequestLogsDTO> listDto = list.map(obj -> new WebRequestLogsDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

	@CrossOrigin
	@PostMapping("/uploadFile")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Arquivo inválido"); 
        }
		service.insertBatch(file);
        return ResponseEntity.ok().build();
    }
	
}
