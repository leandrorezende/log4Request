package br.com.fortbit.logserver.repositories.filters;

import java.time.LocalDate;

public class WebRequestLogsFilter {
	private String ip;
	private LocalDate initialDate;
	private LocalDate finalDate;
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public LocalDate getInitialDate() {
		return initialDate;
	}
	
	public void setInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
	}
	
	public LocalDate getFinalDate() {
		return finalDate;
	}
	
	public void setFinalDate(LocalDate finalDate) {
		this.finalDate = finalDate;
	}
}
