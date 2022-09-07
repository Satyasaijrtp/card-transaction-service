package com.citibank.transaction.model;

public class StatusBlock {
	private String respCode;
	private String respMsg;
	public String getRespCode() {
		return respCode;
	}
	public void setRespCode(String respCode) {
		this.respCode = respCode;
	}
	public String getRespMsg() {
		return respMsg;
	}
	public void setRespMsg(String respMsg) {
		this.respMsg = respMsg;
	}
	@Override
	public String toString() {
		return "StatusBlock [respCode=" + respCode + ", respMsg=" + respMsg + "]";
	}
	

}
