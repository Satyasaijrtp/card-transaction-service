package com.citibank.transaction.builder;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.citibank.transaction.model.StatusBlock;
import com.citibank.transaction.model.Transaction;
import com.citibank.transaction.model.TransactionDao;
import com.citibank.transaction.model.TransactionDaoResponse;
import com.citibank.transaction.model.TransactionResponse;
@Component
public class CardTransactionResponseBuilder {

	 public TransactionResponse buildServiceResponse(TransactionDaoResponse daoResponse) {
		 TransactionResponse transactionResponse = new TransactionResponse();
			// prepare the transaction response with help of transactiondao response
			StatusBlock status = new StatusBlock();
			status.setRespCode(daoResponse.getRespCode());
			status.setRespMsg(daoResponse.getRespMsg());
			transactionResponse.setStatusBlock(status);
			ArrayList<Transaction> arrayList = new ArrayList<Transaction>();
			for (TransactionDao taxDao : daoResponse.getTransactionDaoList()) {
				Transaction transaction = new Transaction();
				transaction.setTxnId(taxDao.getTxnId());
				transaction.setAmount(taxDao.getAmount());
				transaction.setDate(taxDao.getDate());
				transaction.setDescription(taxDao.getDescription());
				transaction.setMerchantName(taxDao.getMerchantName());
				transaction.setRemarks(taxDao.getRemarks());
				transaction.setStatus(taxDao.getStatus());
				
				
			}

				transactionResponse.setTransactionList(arrayList);

		return transactionResponse;
		
		
	}

}
