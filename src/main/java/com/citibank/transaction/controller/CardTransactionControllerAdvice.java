package com.citibank.transaction.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citibank.transaction.exception.BusinessException;
import com.citibank.transaction.exception.CardTransactionRequestInvalidException;
import com.citibank.transaction.exception.SystemException;
import com.citibank.transaction.exception.UnknownServiceException;
import com.citibank.transaction.model.StatusBlock;
import com.citibank.transaction.model.TransactionResponse;

@ControllerAdvice
public class CardTransactionControllerAdvice {
	@ExceptionHandler(value = CardTransactionRequestInvalidException.class)
	@ResponseBody
	public TransactionResponse handleRequestInvalidException(CardTransactionRequestInvalidException ex) {
		TransactionResponse response =buildRespError(ex.getResCode(),ex.getResMsg());
		return response;
		
	}
	@ExceptionHandler(value = BusinessException.class)
	@ResponseBody
	public TransactionResponse handleBusinessException(BusinessException bex) {
		TransactionResponse response = buildRespError(bex.getRespCode(),bex.getRespMsg());
		return response;

	}

	@ExceptionHandler(value = SystemException.class)
	@ResponseBody
	public TransactionResponse handleSystemException(SystemException sex) {
		TransactionResponse response = buildRespError(sex.getRespCode(),sex.getRespMsg());
		return response;


	}
	@ExceptionHandler(value = UnknownServiceException.class)
	@ResponseBody
	public TransactionResponse handleUnknownException(UnknownServiceException uex) {
		TransactionResponse response = buildRespError(uex.getRespCode(),uex.getRespMsg());
				return response;

	}
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public TransactionResponse handleBusinessException(Exception exec) {
		TransactionResponse response = buildRespError("999","unknown error from service");
		return response;

	}
	private TransactionResponse buildRespError(String respCode,String respMsg) {
		TransactionResponse response = new TransactionResponse();
		StatusBlock statusBlock = new StatusBlock();
		statusBlock.setRespCode(respCode);
		statusBlock.setRespMsg(respMsg);
		response.setStatusBlock(statusBlock);
		return response;
	}



}
