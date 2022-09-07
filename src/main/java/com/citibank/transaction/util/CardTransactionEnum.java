	package com.citibank.transaction.util;

public enum CardTransactionEnum {
	clientId100("100","client id invalid","data error"),
	clientId101("101","channel id invalid","data error"),
	clientId102("102","cardnumber is invalid","data error"),
	clientId103("103","cvv is invalid invalid","data error"),
	clientId104("104","expdate is invalid invalid","data error"),
	clientId105("105","name on card is invalid","data error"),
	clientId111("111","data base server is down","system error"),
	clientId222("222","sql Grammer error","system error error"),
	clientId333("333","internal server error","system error"),
	clientId444("555","unknown error","system error");
	
	private String errorCode;
	private String errorMsg;
	private String errorType;
	
	
	 CardTransactionEnum(String errorCode,String errorMsg,String errorType) {
		this.errorCode=errorCode;
		this.errorMsg=errorMsg;
		this.errorType=errorType;
	}
	 public static boolean checkErrorCode(String dbRespCode,String errorType) {
		 //ToDo:if the respcode is present in enum then return true  else return false
		 boolean flag=false;
		 
		 for(CardTransactionEnum cte:CardTransactionEnum.values()) {
			 if(dbRespCode.equals(cte.getErrorCode())&&(errorType.equals(cte.getErrorType()))) {
				 flag=true;
			 }
			 
		 }
		return flag;
		 
	 }


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}


	public String getErrorMsg() {
		return errorMsg;
	}


	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}


	public String getErrorType() {
		return errorType;
	}


	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}
	 

}
