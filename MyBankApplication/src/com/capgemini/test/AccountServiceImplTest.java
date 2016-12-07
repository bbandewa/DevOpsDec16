package com.capgemini.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.model.Account;
import com.capgemini.repo.AccountRepo;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class AccountServiceImplTest {

	@Mock
	AccountRepo repo;
	
	AccountService service;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		service = new AccountServiceImpl(repo);
	}

	@Test
	public void testCreateAccount() throws InsufficientInitialBalanceException {
		Account acc = new Account();
		acc.setAccountNumber(101);
		acc.setAmount(5000);
		
		when(repo.save()).thenReturn(true);
		
		assertEquals(acc, service.createAccount(101, 5000));
	}
	
	@Test(expected=com.capgemini.exceptions.InsufficientInitialBalanceException.class)
	public void whenTheAmountIsLessThan500SystemShouldThrowException() throws InsufficientInitialBalanceException
	{
		service.createAccount(101, 400);
	}

	@Test
	public void testDepositAmount() {
		fail("Not yet implemented");
	}

	@Test
	public void testWithdrawAmount() {
		fail("Not yet implemented");
	}

	@Test
	public void testShowBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testFundTransfer() {
		fail("Not yet implemented");
	}

}
