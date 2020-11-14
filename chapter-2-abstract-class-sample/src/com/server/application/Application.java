package com.server.application;

import com.server.request.FTPRequest;
import com.server.request.HTTPRequest;
import com.server.request.ProtocolRequest;

public class Application {

	public static void main(String[] args) {
		
		String[] ftpHeaders = { "CompanyName:sahibindencom", "FileSize:10", "Mode:SYNC" };
		ProtocolRequest ftpRequest = new FTPRequest("FTP DATA!", ftpHeaders);
		
		String[] httpHeaders = { "CompanyName:sahibindencom", "ContentType:XML", "DataSize:100", "Mode:SYNC" };
		ProtocolRequest httpRequest = new HTTPRequest("HTTP DATA!", httpHeaders);
	}

}
