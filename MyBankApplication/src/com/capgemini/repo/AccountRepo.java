package com.capgemini.repo;

import java.util.List;

import com.capgemini.model.Account;

public interface AccountRepo {

	boolean save();

	boolean deposit(Account account, int amount);

	List<Account> getAllAccounts();

}
