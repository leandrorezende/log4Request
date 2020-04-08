package br.com.fortbit.logserver.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WebRequestLogs implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private LocalDateTime data;
	private String ip;
	private String request;
	private Integer status;
	private String userAgent;
	
	public WebRequestLogs() {
		
	}

	public WebRequestLogs(Integer id, LocalDateTime data, String request, String ip, Integer status, String userAgent) {
		this.id = id;
		this.data = data;
		this.request = request;
		this.ip = ip;
		this.status = status;
		this.userAgent = userAgent;
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

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WebRequestLogs other = (WebRequestLogs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "WebRequestLogs [id=" + id + ", data=" + data + ", ip=" + ip + ", request=" + request + ", status="
				+ status + ", userAgent=" + userAgent + "]";
	}
	
}
