package com.wipro.bank.service;

import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.dao.BankDAO;

public class BankService {
      public String checkBalance(String accountNumber) {
		BankDAO dao=new BankDAO();
		boolean val=dao.validateAccount(accountNumber);
		if(val==true) {
			double bal=dao.findBalance(accountNumber);
			return "BALANCE IS:" + bal;
		}
		else {
			return "ACCOUNT NUMBER INVALID";
		}
	}

      public String transferBean(TransferBean transferBean) {

    	    BankDAO bank = new BankDAO();

    	    if (transferBean == null)
    	        return "INVALID";

    	    if (!bank.validateAccount(transferBean.getFromAccountNumber()) ||
    	        !bank.validateAccount(transferBean.getToAccountNumber()))
    	        return "INVALID ACCOUNT";

    	    double senderBalance =
    	        bank.findBalance(transferBean.getFromAccountNumber());

    	    if (senderBalance < transferBean.getAmount())
    	        return "INSUFFICIENT FUNDS";

    	    double receiverBalance =
    	        bank.findBalance(transferBean.getToAccountNumber());

    	    senderBalance -= transferBean.getAmount();
    	    receiverBalance += transferBean.getAmount();

    	    bank.updateBalance(
    	        transferBean.getFromAccountNumber(), senderBalance);

    	    bank.updateBalance(
    	        transferBean.getToAccountNumber(), receiverBalance);

    	    int txnId = bank.generateSequenceNumber();
    	    transferBean.setTransactionID(txnId);

    	    bank.transferMoney(transferBean);

    	    return "SUCCESS";
    	}

}   

 

