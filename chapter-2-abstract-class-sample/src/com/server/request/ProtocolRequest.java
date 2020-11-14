package com.server.request;

public abstract class ProtocolRequest {

	protected String data;
	protected String[] headers;
	
	protected ProtocolRequest(String data) {
		this.data = data;
		this.headers = new String[100];
	}
	
	protected ProtocolRequest(String data, String[] headers) {
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
