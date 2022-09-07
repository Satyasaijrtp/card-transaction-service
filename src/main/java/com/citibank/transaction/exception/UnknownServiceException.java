package com.citibank.transaction.exception;

public class UnknownServiceException extends Exception {
	private String respCode;
	private String respMsg;

	public UnknownServiceException(String respCode, String respMsg) {
		this.respCode = respCode;
		this.respMsg = respMsg;
	}

	public String getRespCode() {
		return respCode;
	}

	public String getRespMsg() {
		return respMsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnknownServiceException [respCode=");
		builder.append(respCode);
		builder.append(", respMsg=");
		builder.append(respMsg);
		builder.append("]");
		return builder.toString();
	}

}
