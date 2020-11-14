package com.server.request;

public abstract class ProtocolRequest {

	private String data;
	private String[] headers;
	
	public ProtocolRequest(String data) {
		this.data = data;
		this.headers = new String[100];
	}
	
	public ProtocolRequest(String data, String[] headers) {
		this.data = data;
		this.headers = headers;
	}
	
	public String getData() {
		return this.data;
	}
	
	public String[] getHeaders() {
		return this.headers;
	}
	
	public void addHeader(String header) {
		this.headers[this.headers.length - 1] = header;
	}
	
	public abstract String prepareContext();
}
