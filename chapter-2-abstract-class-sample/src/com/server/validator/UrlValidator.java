package com.server.validator;

public abstract class UrlValidator {

	protected String protocolPrefix;
	protected String portNo;
	
	protected UrlValidator(String protocolPrefix, String portNo) {
		this.protocolPrefix = protocolPrefix;
		this.portNo = portNo;
	}
	
	public String getProtocolPrefix() {
		return this.protocolPrefix;
	}
	
	public String getPortNo() {
		return this.portNo;
	}

	public abstract boolean validate(String url);
}
