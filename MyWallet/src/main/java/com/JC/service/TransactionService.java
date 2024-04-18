package com.JC.service;

import java.time.LocalDate;
import java.util.List;

import com.JC.exceptions.CustomerException;
import com.JC.exceptions.TransactionException;
import com.JC.exceptions.WalletException;
import com.JC.model.Transaction;

public interface TransactionService {
	   
	   public Transaction addTransaction(Transaction transaction) throws TransactionException,WalletException;

	   public List<Transaction> findByWallet(String key) throws TransactionException, WalletException, CustomerException;

	   public Transaction findByTransactionId(String key, Integer transactionId)throws TransactionException, CustomerException;

	   public List<Transaction> findByTransactionType(String key, String transactionType) throws TransactionException,CustomerException;

	   public List<Transaction> viewTransactionBetweenDate(String key, LocalDate startDate, LocalDate endDate) throws TransactionException,CustomerException;

	   public List<Transaction> viewAllTransaction()throws TransactionException;

	}