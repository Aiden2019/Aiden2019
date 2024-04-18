package com.JC.service;

import com.JC.exceptions.BillPaymentException;
import com.JC.exceptions.CustomerException;
import com.JC.exceptions.TransactionException;
import com.JC.exceptions.WalletException;

import java.time.LocalDate;

public interface BillPaymentService {

	public String addBillPayment(String targetMobile, String Name, double amount, String BillType, LocalDate paymentDate, Integer walletId, String key) throws BillPaymentException,WalletException,CustomerException,TransactionException;

}