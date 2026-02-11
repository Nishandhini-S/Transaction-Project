package com.wipro.bank.bean;
import java.util.Date;

public class TransferBean {
      private int transactionID;
      private String fromAccountNumber;
      private String toAccountNumber;
      private Date dateofTransaction;
      private double amount;
	  public int getTransactionID() {
		  return transactionID;
	  }
	  public void setTransactionID(int transactionID) {
		  this.transactionID = transactionID;
	  }
	  public String getFromAccountNumber() {
		  return fromAccountNumber;
	  }
	  public void setFromAccountNumber(String fromAccountNumber) {
		  this.fromAccountNumber = fromAccountNumber;
	  }
	  public String getToAccountNumber() {
		  return toAccountNumber;
	  }
	  public void setToAccountNumber(String toAccountNumber) {
		  this.toAccountNumber = toAccountNumber;
	  }
	  public Date getDateofTransaction() {
		  return dateofTransaction;
	  }
	  public void setDateofTransaction(Date dateofTransaction) {
		  this.dateofTransaction = dateofTransaction;
	  }
	  public double getAmount() {
		  return amount;
	  }
	  public void setAmount(double amount) {
		  this.amount = amount;
	  }
      
}
