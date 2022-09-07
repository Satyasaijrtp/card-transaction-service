package com.citibank.transaction.service;

import com.citibank.transaction.exception.BusinessException;
import com.citibank.transaction.exception.SystemException;
import com.citibank.transaction.exception.UnknownServiceException;
import com.citibank.transaction.model.TransactionRequest;
import com.citibank.transaction.model.TransactionResponse;

public interface ICardTransactionService {
	TransactionResponse getTransaction(TransactionRequest request) throws BusinessException, SystemException, UnknownServiceException;

}
