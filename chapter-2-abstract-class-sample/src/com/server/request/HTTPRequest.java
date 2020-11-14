package com.server.request;

public class HTTPRequest extends ProtocolRequest {

	private String[] queryParameters;
	
	public HTTPRequest(String data) {
		super(data);
		this.queryParameters = new String[100];
	}
	
	public HTTPRequest(String data, String[] headers) {
		super(data, headers);
		this.queryParameters = new String[100];
	}
	
	public HTTPRequest(String data, String[] headers, String[] queryParameters) {
		super(data, headers);
		this.queryParameters = queryParameters;
	}

	@Override
	public String prepareContext() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<HTTP>\n");
		
		builder = prepareDataContext(builder);
		builder = prepareHeaderContext(builder);
		builder = prepareQueryParameters(builder);
		
		builder.append("</HTTP>\n");
		
		return builder.toString();
	}
	
	private StringBuilder prepareDataContext(StringBuilder builder) {
		
		builder.append("<DATA>\n");
		builder.append(super.getData());
		builder.append("</DATA>\n");
		return builder;
	}
	
	private StringBuilder prepareHeaderContext(StringBuilder builder) {
		
		builder.append("<HEADER>\n");
		
		for(String header : super.getHeaders()) {
			builder.append("<HEADER>\n");
			builder.append(header);
			builder.append("</HEADER>\n");
		}
		
		builder.append("</HEADER>\n");
		
		return builder;
	}
	
	private StringBuilder prepareQueryParameters(StringBuilder builder) {
		
		builder.append("<QPARAMS>\n");
		
		for(String qParam : this.getQueryParameters()) {
			builder.append("<QPARAM>\n");
			builder.append(qParam);
			builder.append("</QPARAM>\n");
		}
		
		builder.append("</QPARAMS>\n");
		
		return builder;
	}

	public String[] getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(String[] queryParameters) {
		this.queryParameters = queryParameters;
	}
	
	public void addQueryParameter(String queryParam) {
		this.queryParameters[this.queryParameters.length - 1] = queryParam;
	}
}
