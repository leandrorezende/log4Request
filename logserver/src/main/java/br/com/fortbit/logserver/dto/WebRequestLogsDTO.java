package br.com.fortbit.logserver.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import br.com.fortbit.logserver.domain.WebRequestLogs;

public class WebRequestLogsDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private LocalDateTime data;
	private String ip;
	private String request;
	private Integer status;
	private String userAgent;
	
	public WebRequestLogsDTO() {
		
	}

	public WebRequestLogsDTO(WebRequestLogs obj) {
		this.id = obj.getId();
		this.data = obj.getData();
		this.ip = obj.getIp();
		this.request = obj.getRequest();
		this.status = obj.getStatus();
		this.userAgent = obj.getUserAgent();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public LocalDateTime getData() {
		return data;
	}
	
	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
	public String getIp() {
		return ip;
	}
	
	public void setIp(String ip) {
		this.ip = ip;
	}
	
	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getUserAgent() {
		return userAgent;
	}
	
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
}
