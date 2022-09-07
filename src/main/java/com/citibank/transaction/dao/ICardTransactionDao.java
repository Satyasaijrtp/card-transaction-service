package com.citibank.transaction.dao;

import com.citibank.transaction.exception.BusinessException;
import com.citibank.transaction.exception.SystemException;
import com.citibank.transaction.exception.UnknownServiceException;
import com.citibank.transaction.model.TransactionDaoRequest;
import com.citibank.transaction.model.TransactionDaoResponse;

public interface ICardTransactionDao {
	TransactionDaoResponse getAllTransactions(TransactionDaoRequest daoRequest) throws BusinessException, SystemException, UnknownServiceException;

}
