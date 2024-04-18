package com.JC.service;

import com.JC.exceptions.BankAccountException;
import com.JC.exceptions.CustomerException;
import com.JC.model.BankAccount;
import com.JC.model.Wallet;
import com.JC.model.dto.BankAccountDTO;

import java.util.List;
import java.util.Optional;

public interface BankAccountService {
	
	public Wallet addBankAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException,CustomerException;
	
	public Wallet removeBankAccount(String key,BankAccountDTO bankAccountDTO) throws BankAccountException, CustomerException;
	
	public Optional<BankAccount> viewBankAccount(String key, Integer accountNo) throws BankAccountException, CustomerException;
	
	public List<BankAccount> viewAllBankAccounts(String key) throws BankAccountException, CustomerException;

}
