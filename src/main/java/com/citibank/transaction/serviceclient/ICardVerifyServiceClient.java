package com.citibank.transaction.serviceclient;

import com.citibank.transaction.model.CardVerifyRequest;
import com.citibank.transaction.model.CardVerifyResponse;

public interface ICardVerifyServiceClient {

	CardVerifyResponse verifyCard(CardVerifyRequest request);

}
