package com.server.validator;

public class HTTPUrlValidator extends UrlValidator {

	public HTTPUrlValidator(String protocolPrefix, String portNo) {
		super(protocolPrefix, portNo);
	}

	@Override
	public boolean validate(String url) {

		if(url == null) {
			return false;
		}
		
		return url.startsWith(super.getProtocolPrefix());
	}
}
