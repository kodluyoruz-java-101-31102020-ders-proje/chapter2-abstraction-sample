package com.server.instances;

import com.server.request.ProtocolRequest;
import com.server.validator.UrlValidator;

public class HTTPServer extends Server {

	public HTTPServer(UrlValidator urlValidator) {
		super(urlValidator);
	}

	@Override
	public String prepareResponse(ProtocolRequest request) {
		
		String requestContext = request.prepareContext();
		
		System.out.println(requestContext);
		
		if(!requestContext.startsWith("<HTTP>")) {
			return null;
		}
		
		String prefix = "<DATA>";
		int beginIndex = requestContext.indexOf(prefix) + prefix.length();
		int endIndex = requestContext.indexOf("</DATA>");
		
		String data = requestContext.substring(beginIndex, endIndex);
		return "Processed HTTP Data: " + data;
	}

	@Override
	public boolean connect(String url) {
		
		return super.validateUrl(url);
	}

}
