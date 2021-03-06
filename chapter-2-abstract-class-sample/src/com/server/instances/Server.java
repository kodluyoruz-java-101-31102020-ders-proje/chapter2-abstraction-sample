package com.server.instances;

import com.server.request.ProtocolRequest;
import com.server.validator.UrlValidator;

public abstract class Server {

	protected UrlValidator urlValidator;
	
	protected Server(UrlValidator urlValidator) {
		this.urlValidator = urlValidator;
	}
	
	public UrlValidator getUrlValidator() {
		return this.urlValidator;
	}
	
	public boolean validateUrl(String url) {
		
		if(this.urlValidator == null) {
			return false;
		}
		
		return this.urlValidator.validate(url);
	}
	
	
	public abstract boolean connect(String url);
	public abstract String prepareResponse(ProtocolRequest request);
}
