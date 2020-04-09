package br.com.fortbit.logserver.services;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.fortbit.logserver.builders.WebRequestLogsBuilder;
import br.com.fortbit.logserver.domain.WebRequestLogs;
import br.com.fortbit.logserver.repositories.WebRequestLogsRepository;
import br.com.fortbit.logserver.services.exceptions.ObjectNotFoundException;

public class WebRequestLogServiceTest {
	@InjectMocks
	private WebRequestLogService service;

	@Mock
	private WebRequestLogsRepository repo;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void shouldReturnAnWebRequestLogsByPassingAValidId() {
		//scenario
		Optional<WebRequestLogs> obj = Optional.of(WebRequestLogsBuilder.umWebRequestLogs().agora());
		Mockito.doReturn(obj).when(repo).findById(Mockito.anyInt());
		
		//action
		WebRequestLogs webRequesLog = service.find(Mockito.anyInt());
		assertThat(webRequesLog, is(Matchers.instanceOf(WebRequestLogs.class)));
	}
	
	@Test
	public void shouldThrowAnExceptionWhenPassingAInValidId() {
		//scenario
		Integer id = new Integer(2);
		Optional<WebRequestLogs> obj = Optional.empty();
		Mockito.doReturn(obj).when(repo).findById(id);
		
		//verification
		exception.expect(ObjectNotFoundException.class);
		exception.expectMessage("Objeto não encontrado! Id: " + id + ", Tipo: " + WebRequestLogs.class.getName());
		
		//action
		service.find(id);
	}
	
}
