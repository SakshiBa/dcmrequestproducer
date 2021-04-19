package com.somos.dcm.request.transformer;

public class ScpRequestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ScpRequestException(String s){
		super(s);
	}
	
	public ScpRequestException(Exception e){
		super(e);
	}


}
