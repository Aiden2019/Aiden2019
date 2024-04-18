package com.JC.service;

import java.util.List;

import com.JC.exceptions.BeneficiaryException;
import com.JC.exceptions.CustomerException;
import com.JC.exceptions.WalletException;
import com.JC.model.Beneficiary;
import com.JC.model.dto.BeneficiaryDTO;

public interface BeneficiaryService {
	
	public Beneficiary addBeneficiary(Beneficiary beneficiary, String key) throws BeneficiaryException, CustomerException, WalletException;

	public List<Beneficiary> findAllByWallet(Integer walletId) throws BeneficiaryException;

	public Beneficiary viewBeneficiary(String beneficiaryName, String key) throws BeneficiaryException, CustomerException;

	public List<Beneficiary> viewAllBeneficiary(String key) throws BeneficiaryException, CustomerException;

	public Beneficiary deleteBeneficiary(String key, BeneficiaryDTO beneficiaryDTO) throws BeneficiaryException, CustomerException;

}
