package com.server.request;

public class HTTPRequest extends ProtocolRequest {

	private String[] queryParameters;
	
	public HTTPRequest(String data) {
		super(data);
	}
	
	public HTTPRequest(String data, String[] headers) {
		super(data, headers);
	}

	@Override
	public String prepareContext() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<HTTP>");
		
		builder = prepareDataContext(builder);
		builder = prepareHeaderContext(builder);
		builder = prepareQueryParameters(builder);
		
		builder.append("</HTTP>");
		
		return builder.toString();
	}
	
	private StringBuilder prepareDataContext(StringBuilder builder) {
		
		builder.append("<DATA>");
		builder.append(super.getData());
		builder.append("</DATA>");
		return builder;
	}
	
	private StringBuilder prepareHeaderContext(StringBuilder builder) {
		
		builder.append("<HEADER>");
		
		for(String header : super.getHeaders()) {
			builder.append("<HEADER>");
			builder.append(header);
			builder.append("</HEADER>");
		}
		
		builder.append("</HEADER>");
		
		return builder;
	}
	
	private StringBuilder prepareQueryParameters(StringBuilder builder) {
		
		builder.append("<QPARAMS>");
		
		for(String qParam : this.getQueryParameters()) {
			builder.append("<QPARAM>");
			builder.append(qParam);
			builder.append("</QPARAM>");
		}
		
		builder.append("</QPARAMS>");
		
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
