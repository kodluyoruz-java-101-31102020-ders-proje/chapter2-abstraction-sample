package com.server.request;

public class FTPRequest extends ProtocolRequest {

	public FTPRequest(String data) {
		super(data);
	}
	
	public FTPRequest(String data, String[] headers) {
		super(data, headers);
	}

	@Override
	public String prepareContext() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("<FTP>");
		
		builder = prepareDataContext(builder);
		builder = prepareHeaderContext(builder);
		
		builder.append("</FTP>");
		
		return builder.toString();
	}

	private StringBuilder prepareDataContext(StringBuilder builder) {
		
		builder.append("<FDATA>");
		builder.append(super.getData());
		builder.append("</FDATA>");
		return builder;
	}
	
	private StringBuilder prepareHeaderContext(StringBuilder builder) {
		
		builder.append("<FHEADER>");
		
		for(String header : super.getHeaders()) {
			builder.append("<FHEADER>");
			builder.append(header);
			builder.append("</FHEADER>");
		}
		
		builder.append("</FHEADER>");
		
		return builder;
	}
	
}
