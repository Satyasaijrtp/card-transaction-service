package com.citibank.transaction.exception;

public class CardTransactionRequestInvalidException extends Exception {
	private String resCode;
	private String resMsg;
	
	public CardTransactionRequestInvalidException(String resCode,String resMsg ) {
		this.resCode=resCode;
		this.resMsg=resMsg;
		
	}

	public String getResCode() {
		return resCode;
	}

	public String getResMsg() {
		return resMsg;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CardTransactionRequestInvalidException [resCode=");
		builder.append(resCode);
		builder.append(", resMsg=");
		builder.append(resMsg);
		builder.append("]");
		return builder.toString();
	}
	

}
