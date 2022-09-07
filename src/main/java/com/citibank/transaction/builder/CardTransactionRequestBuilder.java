package com.citibank.transaction.builder;

import org.springframework.stereotype.Component;

import com.citibank.transaction.model.CardVerifyRequest;
import com.citibank.transaction.model.CardVerifyResponse;
import com.citibank.transaction.model.TransactionDaoRequest;
import com.citibank.transaction.model.TransactionRequest;
@Component
public class CardTransactionRequestBuilder {
	//this method is used to prepare the dao request with help oo service request

	public TransactionDaoRequest buildRequestDao(TransactionRequest request) {
		TransactionDaoRequest daoRequest = new TransactionDaoRequest();
		daoRequest.setCardNumber(request.getCardNum());
		daoRequest.setCvv(request.getCvv());
		daoRequest.setNameOnCard(request.getNameOncard());
		daoRequest.setExpDate(request.getExpdate());
		daoRequest.setClientid(request.getClientId());

		return daoRequest;
	}

	
	public CardVerifyRequest buildCardVerifyCardRequest(TransactionRequest request) {
		CardVerifyRequest cardVerifyRequest = new CardVerifyRequest();
		cardVerifyRequest.setCardNum(request.getCardNum());
		cardVerifyRequest.setCvv(request.getCvv());
		cardVerifyRequest.setExpDate(request.getExpdate());
		cardVerifyRequest.setNameCard(request.getNameOncard());
		
		// TODO Auto-generated method stub
		return cardVerifyRequest;
	}

}
