package com.capgemini.service;

import java.util.List;
import java.util.StringJoiner;

import com.capgemini.exceptions.InsufficientBalanceException;
import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repo.AccountRepo;

public class AccountServiceImpl implements AccountService {

	AccountRepo repo;

	public AccountServiceImpl(AccountRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		if (500 > amount) {
			throw new InsufficientInitialBalanceException();
		}

		Account account = new Account();
		account.setAccountNumber(accountNumber);
		account.setAmount(amount);

		if (repo.save()) {
			return account;
		}

		return null;
	}

	@Override
	public int depositAmount(int accountNumber, int amount) throws InvalidAccountNumberException {
		List<Account> accounts = repo.getAllAccounts();
		
		for(Account account : accounts){
			if(account.getAccountNumber() == accountNumber){
				if(repo.deposit(account, amount)){
					account.getAmount();
				}
			}
		}
		
		
		return 0;
	}

	@Override
	public int withdrawAmount(int accountNumber, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public StringJoiner fundTransfer(int fromAccount, int toAccount, int amount)
			throws InvalidAccountNumberException, InsufficientBalanceException {
		// TODO Auto-generated method stub
		return null;
	}

}
