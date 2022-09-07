package com.citibank.transaction.model;

import java.util.List;

public class TransactionDaoResponse {
	private String respCode;
	private String respMsg;
	private List<TransactionDao> transactionDaoList;
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
	public List<TransactionDao> getTransactionDaoList() {
		return transactionDaoList;
	}
	public void setTransactionDaoList(List<TransactionDao> transactionDaoList) {
		this.transactionDaoList = transactionDaoList;
	}
	

}
