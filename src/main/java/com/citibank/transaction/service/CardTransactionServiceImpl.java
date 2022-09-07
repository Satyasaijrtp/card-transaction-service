package com.citibank.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.citibank.transaction.builder.CardTransactionRequestBuilder;
import com.citibank.transaction.builder.CardTransactionResponseBuilder;
import com.citibank.transaction.dao.ICardTransactionDao;
import com.citibank.transaction.exception.BusinessException;
import com.citibank.transaction.exception.SystemException;
import com.citibank.transaction.exception.UnknownServiceException;
import com.citibank.transaction.model.CardVerifyRequest;
import com.citibank.transaction.model.CardVerifyResponse;
import com.citibank.transaction.model.TransactionDaoRequest;
import com.citibank.transaction.model.TransactionDaoResponse;
import com.citibank.transaction.model.TransactionRequest;
import com.citibank.transaction.model.TransactionResponse;
import com.citibank.transaction.serviceclient.ICardVerifyServiceClient;

@Component
public class CardTransactionServiceImpl implements ICardTransactionService {
	@Autowired
	ICardVerifyServiceClient cardVerifyServiceClient;
	@Autowired
	ICardTransactionDao cardTransactionDaoImpl;
	@Autowired
	CardTransactionResponseBuilder cardTransactionResponseBuilder;
	@Autowired
	CardTransactionRequestBuilder cardTransactionRequestBuilder;

	@Override
	public TransactionResponse getTransaction(TransactionRequest request)
			throws BusinessException, SystemException, UnknownServiceException {
		TransactionDaoResponse daoResponse = null;
		// 1 get the request from controller
		// 2 prepare the request foe cardverifyservice client
		CardVerifyRequest cardVerifyRequest = cardTransactionRequestBuilder.buildCardVerifyCardRequest(request);

		
		// 3call verifyservice and get response
		CardVerifyResponse cardVerifyResponse = cardVerifyServiceClient.verifyCard(cardVerifyRequest);

		// 4 verify the response .if card is active then only call dao layer else will
		// send error
		if ("active".equals(cardVerifyResponse.getStatus())) {
			// call request builder for dao request
			TransactionDaoRequest daoRequest=cardTransactionRequestBuilder.buildRequestDao(request);
			
			// call dao layer and get the response
			daoResponse = cardTransactionDaoImpl.getAllTransactions(daoRequest);

		}
		//cal response builder
		TransactionResponse response=cardTransactionResponseBuilder.buildServiceResponse(daoResponse);
				return response;
		
	}

}
