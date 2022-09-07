package com.citibank.transaction.model;

import java.util.List;

public class TransactionResponse {
	private StatusBlock statusBlock;
	private List<Transaction> transactionList;
	public StatusBlock getStatusBlock() {
		return statusBlock;
	}
	public void setStatusBlock(StatusBlock statusBlock) {
		this.statusBlock = statusBlock;
	}
	public List<Transaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}
	@Override
	public String toString() {
		return "TransactionResponse [statusBlock=" + statusBlock + ", transactionList=" + transactionList + "]";
	}
	
}
