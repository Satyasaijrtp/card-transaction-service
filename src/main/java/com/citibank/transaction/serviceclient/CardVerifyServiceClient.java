package com.citibank.transaction.serviceclient;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.citibank.transaction.model.CardVerifyRequest;
import com.citibank.transaction.model.CardVerifyResponse;

@Component
public class CardVerifyServiceClient implements ICardVerifyServiceClient {
	
	private String transacionUri=null;

	@Override
	public CardVerifyResponse verifyCard(CardVerifyRequest request) {
		//1.get the request from the service
		//2.prepare the request for cardverify service
		//3.call cardverifyservice and get the response
		transacionUri="http://localhost:2025/v1/cardverifyservice/verification";
		RestTemplate restTemplate = new RestTemplate();
		LinkedMultiValueMap<String, String> headers = new LinkedMultiValueMap<String,String>();
		headers.add("client-id", "netbanking");
		headers.add("msg-ts", new Date().toString());
		headers.add("request-id", UUID.randomUUID().toString());
		HttpEntity<Object> httpEntity = new HttpEntity<>(request,headers );
		ResponseEntity<CardVerifyResponse> responseEntity = restTemplate.exchange(transacionUri, HttpMethod.POST, httpEntity, CardVerifyResponse.class);
		CardVerifyResponse response=null;
		System.out.println("responseEntitity:"+responseEntity);
		System.out.println("status:"+responseEntity.getStatusCode().OK.value());
		if(responseEntity.getStatusCode().OK.value()==200) {
			response=responseEntity.getBody();
		}
		
		//4.prepare the cardverify response
		//5.send response to service layer
		

		return response;
	}
		
		public static void main(String[] arg) {
			CardVerifyServiceClient svcImp = new CardVerifyServiceClient();
			CardVerifyRequest cardVerifyRequest = new CardVerifyRequest();
			cardVerifyRequest.setCardNum("93456789999");
			cardVerifyRequest.setCvv("123");
			cardVerifyRequest.setExpDate("31-08-2022");
			cardVerifyRequest.setNameCard("sai");
			
			
			CardVerifyResponse verifyCard = svcImp.verifyCard(cardVerifyRequest);
		}
	}


