package com.herick.money.api.event;

import org.springframework.context.ApplicationEvent;

import jakarta.servlet.http.HttpServletResponse;

public class RecursoCriadoEvent extends ApplicationEvent {

	private static final long serialVersionUID = -4543567268266151728L;
	private HttpServletResponse response;
	private Long codigo;

	public RecursoCriadoEvent(Object source, HttpServletResponse response, Long codigo) {
		super(source);
		this.codigo = codigo;
		this.response = response;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getCodigo() {
		return codigo;
	}
	
	

}
