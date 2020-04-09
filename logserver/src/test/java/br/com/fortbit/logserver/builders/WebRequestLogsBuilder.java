package br.com.fortbit.logserver.builders;

import java.time.LocalDateTime;

import br.com.fortbit.logserver.domain.WebRequestLogs;


public class WebRequestLogsBuilder {
	private WebRequestLogs elemento;
	private WebRequestLogsBuilder(){}

	public static WebRequestLogsBuilder umWebRequestLogs() {
		WebRequestLogsBuilder builder = new WebRequestLogsBuilder();
		inicializarDadosPadroes(builder);
		return builder;
	}

	public static void inicializarDadosPadroes(WebRequestLogsBuilder builder) {
		builder.elemento = new WebRequestLogs();
		WebRequestLogs elemento = builder.elemento;

		
		elemento.setId(0);
		elemento.setData(null);
		elemento.setIp("");
		elemento.setRequest("");
		elemento.setStatus(0);
		elemento.setUserAgent("");
	}

	public WebRequestLogsBuilder comId(Integer param) {
		elemento.setId(param);
		return this;
	}

	public WebRequestLogsBuilder comData(LocalDateTime param) {
		elemento.setData(param);
		return this;
	}

	public WebRequestLogsBuilder comIp(String param) {
		elemento.setIp(param);
		return this;
	}

	public WebRequestLogsBuilder comRequest(String param) {
		elemento.setRequest(param);
		return this;
	}

	public WebRequestLogsBuilder comStatus(Integer param) {
		elemento.setStatus(param);
		return this;
	}

	public WebRequestLogsBuilder comUserAgent(String param) {
		elemento.setUserAgent(param);
		return this;
	}

	public WebRequestLogs agora() {
		return elemento;
	}
}
