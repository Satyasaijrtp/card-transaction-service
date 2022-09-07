package com.citibank.transaction.model;

public class TransactionDao {
	private String txnId;
	private String date;
	private String name;
	private String merchantName;
	private float amount;
	private String description;
	private String status;
	private String remarks;
	public String getTxnId() {
		return txnId;
	}
	public void setTxnId(String txnId) {
		this.txnId = txnId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDaos [txnId=");
		builder.append(txnId);
		builder.append(", date=");
		builder.append(date);
		builder.append(", name=");
		builder.append(name);
		builder.append(", merchantName=");
		builder.append(merchantName);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", description=");
		builder.append(description);
		builder.append(", status=");
		builder.append(status);
		builder.append(", remarks=");
		builder.append(remarks);
		builder.append("]");
		return builder.toString();
	}
	

	}
