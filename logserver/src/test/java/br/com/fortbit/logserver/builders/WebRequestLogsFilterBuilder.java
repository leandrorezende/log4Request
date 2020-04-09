package br.com.fortbit.logserver.builders;

import java.time.LocalDate;

import br.com.fortbit.logserver.repositories.filters.WebRequestLogsFilter;


public class WebRequestLogsFilterBuilder {
	private WebRequestLogsFilter elemento;
	private WebRequestLogsFilterBuilder(){}

	public static WebRequestLogsFilterBuilder umWebRequestLogsFilter() {
		WebRequestLogsFilterBuilder builder = new WebRequestLogsFilterBuilder();
		inicializarDadosPadroes(builder);
		return builder;
	}

	public static void inicializarDadosPadroes(WebRequestLogsFilterBuilder builder) {
		builder.elemento = new WebRequestLogsFilter();
		WebRequestLogsFilter elemento = builder.elemento;

		
		elemento.setIp("");
		elemento.setInitialDate(null);
		elemento.setFinalDate(null);
	}

	public WebRequestLogsFilterBuilder comIp(String param) {
		elemento.setIp(param);
		return this;
	}

	public WebRequestLogsFilterBuilder comInitialDate(LocalDate param) {
		elemento.setInitialDate(param);
		return this;
	}

	public WebRequestLogsFilterBuilder comFinalDate(LocalDate param) {
		elemento.setFinalDate(param);
		return this;
	}

	public WebRequestLogsFilter agora() {
		return elemento;
	}
}
