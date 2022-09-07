package com.citibank.transaction.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citibank.transaction.exception.BusinessException;
import com.citibank.transaction.exception.CardTransactionRequestInvalidException;
import com.citibank.transaction.exception.SystemException;
import com.citibank.transaction.exception.UnknownServiceException;
import com.citibank.transaction.model.StatusBlock;
import com.citibank.transaction.model.Transaction;
import com.citibank.transaction.model.TransactionRequest;
import com.citibank.transaction.model.TransactionResponse;
import com.citibank.transaction.service.CardTransactionServiceImpl;
import com.citibank.transaction.service.ICardTransactionService;
import com.citibank.transaction.validator.CardTransactionValidator;

@RestController
@RequestMapping("/v1")
public class CardTransactionController {
	@Autowired
	CardTransactionValidator cardTransactionValidator;
	@Autowired
	ICardTransactionService cardTransactionServiceImpl;

	@GetMapping("/card/transaction/{cardNum}/{cvv}/{nameOnCard}/{expdate}")
	public TransactionResponse getTransaction(@PathVariable("cardNum") String cardNum, @PathVariable("cvv") String cvv,
			@PathVariable("nameOnCard") String nameOncard, @PathVariable("expdate") String expdate,
			@RequestParam("startdate") String startdate, @RequestParam("enddate") String enddate,
			@RequestParam("sortType") String sortType, @RequestParam("sortField") String sortField,
			@RequestHeader("client-id") String clientId, @RequestHeader("request-id") String requestId,
			@RequestHeader("message-ts") String messageTs

	) throws CardTransactionRequestInvalidException, BusinessException, SystemException, UnknownServiceException  {

		// 1.get the request from client
		TransactionRequest request = new TransactionRequest();
		request.setCardNum(cardNum);
		request.setCvv(cvv);
		request.setNameOncard(nameOncard);
		request.setExpdate(expdate);
		request.setStartdate(startdate);
		request.setEnddate(enddate);
		request.setSortType(sortType);
		request.setSortField(sortField);
		request.setClientId(clientId);
		request.setRequestid(requestId);
		request.setMessageTs(messageTs);
		// 2.validate the request
		// 2.1 if request is valid the request process step 3
		// 2.2 if request is not valid throw user define exception and send error
		// response to client
		cardTransactionValidator.validateRequest(request);

		// 3 prepare the request for service class
		// 4 call service layer and get response
		TransactionResponse transactionResponse2 = cardTransactionServiceImpl.getTransaction(request);

		TransactionResponse transactionResponse = new TransactionResponse();
		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode("0");
		statusBlock.setRespMsg("Success");

		List<Transaction> transactionList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Transaction transaction1 = new Transaction();
			transaction1.setTxnId("11111" + i);
			transaction1.setDate("11-08-2022");
			transaction1.setName("iphone mobile");
			transaction1.setAmount(1000000.00f);
			transaction1.setMerchantName("lifestyle");
			transaction1.setDescription("yyyyyyy");
			transaction1.setStatus("success");
			transaction1.setRemarks("no");
			transactionList.add(transaction1);

		}

		transactionResponse.setStatusBlock(statusBlock);
		transactionResponse.setTransactionList(transactionList);

		return transactionResponse;

	}
}
