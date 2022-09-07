package com.citibank.transaction.model;

public class CardVerifyRequest {
	private String cardNum;
	private String cvv;
	private String expDate;
	private String nameCard;
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getNameCard() {
		return nameCard;
	}
	public void setNameCard(String nameCard) {
		this.nameCard = nameCard;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VerifyCardRequest [cardNum=");
		builder.append(cardNum);
		builder.append(", cvv=");
		builder.append(cvv);
		builder.append(", expDate=");
		builder.append(expDate);
		builder.append(", nameCard=");
		builder.append(nameCard);
		builder.append("]");
		return builder.toString();
	}
	

}
