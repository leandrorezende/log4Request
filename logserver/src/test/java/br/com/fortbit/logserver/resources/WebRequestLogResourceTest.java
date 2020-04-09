package br.com.fortbit.logserver.resources;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import br.com.fortbit.logserver.builders.WebRequestLogsBuilder;
import br.com.fortbit.logserver.domain.WebRequestLogs;
import br.com.fortbit.logserver.dto.WebRequestLogsDTO;
import br.com.fortbit.logserver.services.WebRequestLogService;
import br.com.fortbit.logserver.services.exceptions.ObjectNotFoundException;

public class WebRequestLogResourceTest {
	@InjectMocks
	private WebRequestLogResource resource;

	@Mock
	private WebRequestLogService service;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenRequestWebRequestLogDataReturn200() {
		// scenario
		List<WebRequestLogs> listDto = new ArrayList<>();
		listDto.add(WebRequestLogsBuilder.umWebRequestLogs().agora());
		Mockito.doReturn(listDto).when(service).findAll();

		// action
		ResponseEntity<List<WebRequestLogsDTO>> response = resource.findAll();

		// verification
		assertThat(response.getStatusCode().value(), is(200));
		List<WebRequestLogsDTO> body = (List<WebRequestLogsDTO>) response.getBody();
		assertThat(body.get(0), is(Matchers.instanceOf(WebRequestLogsDTO.class)));
	}
	
	@Test
    @SuppressWarnings("rawtypes")
	public void whenRequestSearchWebRequestLogReturn200() {
		//scenario
		WebRequestLogs webRequestLog = WebRequestLogsBuilder.umWebRequestLogs().agora();
		Mockito.doReturn(webRequestLog).when(service).find(Mockito.anyInt());
		
		//action
		ResponseEntity response = resource.find(Mockito.anyInt());
		
		//verification
        assertThat(response.getStatusCode().value(), is(200));
        WebRequestLogs body = (WebRequestLogs) response.getBody();
        assertThat(body, is(Matchers.instanceOf(WebRequestLogs.class)));
	}
	
	@Test(expected = ObjectNotFoundException.class)
	public void whenRequestSearchWebRequestLogReturnException() {
		//scenario
		Mockito.doThrow(ObjectNotFoundException.class).when(service).find(Mockito.anyInt());
		
		//action
		resource.find(Mockito.anyInt());
	}
}
