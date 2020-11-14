package com.server.application;

import com.server.instances.FTPServer;
import com.server.instances.HTTPServer;
import com.server.instances.Server;
import com.server.request.FTPRequest;
import com.server.request.HTTPRequest;
import com.server.request.ProtocolRequest;
import com.server.validator.FTPUrlValidator;
import com.server.validator.HTTPUrlValidator;
import com.server.validator.UrlValidator;

public class Application {

	public static void main(String[] args) {
		
		// request check
		
		String[] ftpHeaders = { "CompanyName:sahibindencom", "FileSize:10", "Mode:SYNC" };
		ProtocolRequest ftpRequest = new FTPRequest("FTP DATA!", ftpHeaders);
		
		ftpRequest.addHeader("Xtype:UnixFile");
		
		//System.out.println(ftpRequest.prepareContext());
		
		String[] httpHeaders = { "CompanyName:sahibindencom", "ContentType:XML", "DataSize:100", "Mode:SYNC" };
		String[] queryParameters = { "department=Engineering", "page=1" };
		ProtocolRequest httpRequest = new HTTPRequest("HTTP DATA!", httpHeaders, queryParameters);
		
		httpRequest.addHeader("AcceptedContentType:String");
		((HTTPRequest)httpRequest).addQueryParameter("query='Mehmet'");
		((HTTPRequest)httpRequest).addQueryParameter("query='Hasan'");
		
		//System.out.println(httpRequest.prepareContext());
		
		
		UrlValidator ftpUrlValidator = new FTPUrlValidator("ftp:", ":21");
		Server ftpServer = new FTPServer(ftpUrlValidator);
		
		String ftpUrl = "ftp://abc.com:21/folder_name/sub_folder";
		boolean connection = ftpServer.connect(ftpUrl);
		
		if(connection) {
			System.out.println(ftpServer.prepareResponse(ftpRequest));
		}
		
		
		UrlValidator httpUrlValidator = new HTTPUrlValidator("http:", ":80");
		Server httpServer = new HTTPServer(httpUrlValidator);
		
		String httpUrl = "http://www.google.com";
		connection = httpServer.connect(httpUrl);
		
		if(connection) {
			System.out.println(httpServer.prepareResponse(httpRequest));
		}
		
		
		// validation check
		
		/*
		String ftpUrl = "ftp://abc.com:21/folder_name/sub_folder";
		UrlValidator ftpUrlValidator = new FTPUrlValidator("ftp:", ":21");
		
		boolean ftpValidationResult = ftpUrlValidator.validate(ftpUrl);
		
		System.out.println("FTP Validation: " + ftpValidationResult);
		
		
		String httpUrl = "http://www.google.com";
		UrlValidator httpUrlValidator = new HTTPUrlValidator("http:", ":80");
		
		boolean httpValidationResult = httpUrlValidator.validate(httpUrl);

		System.out.println("HTTP Validation: " + httpValidationResult);
		*/
		
	}

}
