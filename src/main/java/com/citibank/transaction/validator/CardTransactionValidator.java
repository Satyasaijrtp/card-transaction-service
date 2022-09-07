package com.citibank.transaction.validator;

import org.springframework.stereotype.Component;

import com.citibank.transaction.exception.CardTransactionRequestInvalidException;
import com.citibank.transaction.model.TransactionRequest;

@Component
public class CardTransactionValidator {

	public void validateRequest(TransactionRequest transactionRequest) throws CardTransactionRequestInvalidException {
		if (transactionRequest.getClientId() == null || " ".equals(transactionRequest.getClientId())) {
			throw new CardTransactionRequestInvalidException("tax101", "invalid Clientid");
		}
		if (transactionRequest.getCvv() == null || " ".equals(transactionRequest.getCvv())) {
			throw new CardTransactionRequestInvalidException("tax102", "invalid Cvv");
		}
		if (transactionRequest.getCardNum() == null || " ".equals(transactionRequest.getCardNum())||transactionRequest.getCardNum().length() != 16){
			throw new CardTransactionRequestInvalidException("tax103", "invalid Clientid");
		}

	}

}
