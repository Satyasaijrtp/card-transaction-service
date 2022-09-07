package com.citibank.transaction.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.citibank.transaction.exception.BusinessException;
import com.citibank.transaction.exception.SystemException;
import com.citibank.transaction.exception.UnknownServiceException;
import com.citibank.transaction.model.TransactionDaoRequest;
import com.citibank.transaction.model.TransactionDaoResponse;
import com.citibank.transaction.util.CardTransactionConstants;
import com.citibank.transaction.util.CardTransactionEnum;
import com.citibank.transaction.model.TransactionDao;

@Component
public class CardTransactionDaoImpl implements ICardTransactionDao {

	@Override
	public TransactionDaoResponse getAllTransactions(TransactionDaoRequest daoRequest) throws BusinessException, SystemException, UnknownServiceException {
	TransactionDaoResponse daoResp = new TransactionDaoResponse();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("hhtp://localhost:3306/crr","root","root");
			String sql="{CALL crr.GET_ALL_TRANSACTIONS(?,?,?,?,?,?,?,?}";
			CallableStatement csmt = con.prepareCall(sql);
			//bind the vale to parameter
			csmt.setString(1,daoRequest.getClientid());
			csmt.setString(2,CardTransactionConstants.CHANNEI_ID);
			csmt.setString(3,daoRequest.getCardNumber());
			csmt.setString(4,daoRequest.getCvv());
			csmt.setString(5,daoRequest.getNameOnCard());
			csmt.setString(6,daoRequest.getExpDate());
			
			//register out param
			csmt.registerOutParameter(7,java.sql.Types.VARCHAR);
			csmt.registerOutParameter(8,java.sql.Types.VARCHAR);
			boolean b = csmt.execute();
			System.out.println("boolean vale is"+b);
			

			
		
			String dbRespCode = csmt.getString(7);
			String dbRespMsg = csmt.getString(8);
			System.out.println("respCode::"+dbRespCode+"______________"+"respMsg:::"+dbRespMsg);
			
			
			
			// get the request for service layer
			
			// prepare the request for database
			// call database and get response ResultSet
			daoResp.setRespCode(dbRespCode);
			daoResp.setRespMsg(dbRespMsg);
			
			if (CardTransactionConstants.ZERO.equals(dbRespCode)) {
				List<TransactionDao> list=new ArrayList<TransactionDao>();
				ResultSet rs = csmt.executeQuery();
				while(rs.next()) {
					TransactionDao transactionDaos = new TransactionDao();
					transactionDaos.setTxnId(rs.getString(CardTransactionConstants.TNX_ID));
					transactionDaos.setName(rs.getString(CardTransactionConstants.TNX_NAME));
					transactionDaos.setDate(rs.getString(CardTransactionConstants.DATE));
					transactionDaos.setAmount(Float.valueOf(rs.getString("amount")));
					transactionDaos.setMerchantName(rs.getString(CardTransactionConstants.MERCHANTNAME));
					transactionDaos.setDescription(rs.getString(CardTransactionConstants.DESCRIPTION));
					transactionDaos.setStatus(rs.getString(CardTransactionConstants.STATUS));
					list.add(transactionDaos);
				}
				daoResp.setTransactionDaoList(list);

			} else if (CardTransactionEnum.checkErrorCode(dbRespCode, CardTransactionConstants.DATA_ERROR)) {
				throw new BusinessException(dbRespCode, dbRespMsg);
			} else if (CardTransactionEnum.checkErrorCode(dbRespCode, CardTransactionConstants.SYSTEM_ERROR)) {
				throw new SystemException(dbRespCode, dbRespMsg);
			}
			else {
				throw new UnknownServiceException(dbRespCode, dbRespMsg);
			}
		} catch (BusinessException be) {
			be.printStackTrace();
			throw be;
		}
		catch (SystemException se) {
			se.printStackTrace();
			throw se;
		}
		catch (UnknownServiceException ue) {
			ue.printStackTrace();
			throw ue;
		}
		catch (Exception e) {
		e.printStackTrace();
			throw new UnknownServiceException("44444","unknown error from db");
		}
		
		// prepare dao response with help of database response
		// send dao response to servicelayer
		return daoResp;
	}

}
