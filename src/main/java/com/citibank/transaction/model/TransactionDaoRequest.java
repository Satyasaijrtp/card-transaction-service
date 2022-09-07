package com.citibank.transaction.model;

public class TransactionDaoRequest {
	private String clientid;
	private String cardNumber;
	private String cvv;
	private String nameOnCard;
	private String expDate;
	private String stDate;
	private String endDate;

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCvv() {
		return cvv;
	}

	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	public String getNameOnCard() {
		return nameOnCard;
	}

	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getStDate() {
		return stDate;
	}

	public void setStDate(String stDate) {
		this.stDate = stDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionDaoRequest [clientid=");
		builder.append(clientid);
		builder.append(", cardNumber=");
		builder.append(cardNumber);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", nameOnCard=");
		builder.append(nameOnCard);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", stDate=");
		builder.append(stDate);
		builder.append(", endDate=");
		builder.append(endDate);
		builder.append("]");
		return builder.toString();
	}

}
