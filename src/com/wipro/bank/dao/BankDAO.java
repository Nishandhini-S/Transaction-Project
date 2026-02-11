package com.wipro.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.wipro.bank.bean.TransferBean;
import com.wipro.bank.util.DBUtil;

public class BankDAO {

    public int generateSequenceNumber() {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT transactionId_seq.NEXTVAL FROM DUAL";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean validateAccount(String accountNumber) {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT * FROM Account_tbl WHERE Account_Number = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public double findBalance(String accountNumber) {
        Connection connection = DBUtil.getDBConnection();
        String query = "SELECT Balance FROM Account_tbl WHERE Account_Number = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, accountNumber);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getDouble("Balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public boolean updateBalance(String accountNumber, double newBalance) {
        Connection connection = DBUtil.getDBConnection();
        String query = "UPDATE Account_tbl SET Balance=? WHERE Account_Number=?";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setDouble(1, newBalance);
            ps.setString(2, accountNumber);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean transferMoney(TransferBean transferBean) {

        Connection connection = DBUtil.getDBConnection();

        String query =
        		"INSERT INTO TRANSFER_TBL " +
        		"(Transaction_ID, Account_Number, Beneficiary_Account_Number, Transaction_Date, Transaction_Amount) " +
        		"VALUES (?, ?, ?, ?, ?)";


        try {
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setInt(1, transferBean.getTransactionID());
            ps.setString(2, transferBean.getFromAccountNumber());
            ps.setString(3, transferBean.getToAccountNumber());
            ps.setDate(4, new java.sql.Date(
                    transferBean.getDateofTransaction().getTime()));
            ps.setDouble(5, transferBean.getAmount());


            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
