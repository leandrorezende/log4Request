package br.com.fortbit.logserver.builders;

import java.time.LocalDateTime;

import br.com.fortbit.logserver.dto.WebRequestLogsDTO;


public class WebRequestLogsDTOBuilder {
	private WebRequestLogsDTO elemento;
	private WebRequestLogsDTOBuilder(){}

	public static WebRequestLogsDTOBuilder umWebRequestLogsDTO() {
		WebRequestLogsDTOBuilder builder = new WebRequestLogsDTOBuilder();
		inicializarDadosPadroes(builder);
		return builder;
	}

	public static void inicializarDadosPadroes(WebRequestLogsDTOBuilder builder) {
		builder.elemento = new WebRequestLogsDTO();
		WebRequestLogsDTO elemento = builder.elemento;

		
		elemento.setId(0);
		elemento.setData(null);
		elemento.setIp("");
		elemento.setRequest("");
		elemento.setStatus(0);
		elemento.setUserAgent("");
	}

	public WebRequestLogsDTOBuilder comId(Integer param) {
		elemento.setId(param);
		return this;
	}

	public WebRequestLogsDTOBuilder comData(LocalDateTime param) {
		elemento.setData(param);
		return this;
	}

	public WebRequestLogsDTOBuilder comIp(String param) {
		elemento.setIp(param);
		return this;
	}

	public WebRequestLogsDTOBuilder comRequest(String param) {
		elemento.setRequest(param);
		return this;
	}

	public WebRequestLogsDTOBuilder comStatus(Integer param) {
		elemento.setStatus(param);
		return this;
	}

	public WebRequestLogsDTOBuilder comUserAgent(String param) {
		elemento.setUserAgent(param);
		return this;
	}

	public WebRequestLogsDTO agora() {
		return elemento;
	}
}
