package com.capgemini.test;

import static org.junit.Assert.*;

import javax.naming.InsufficientResourcesException;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.beans.Account;
import com.capgemini.exception.DuplicateAccountException;
import com.capgemini.exception.InsufficientBalanceExceptyion;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

public class BankAppTestCases {

	AccountService accountService;
	
	
	@Before
	public void setUp() throws Exception
	{
		accountService = new AccountServiceImpl();
	}
	
	/**
	 * Test 1: Initial insufficient balance.
	 * 
	 * @throws InsufficientBalanceExceptyion
	 */
	@Test(expected = com.capgemini.exception.InsufficientBalanceExceptyion.class)
	public void whenAmountLess() throws InsufficientBalanceExceptyion, DuplicateAccountException {
		
		accountService.createAccount(101,300);
	}
	
	/**
	 * Test 2: Add account successfully.
	 * @throws InsufficientBalanceExceptyion
	 */
	@Test
	public void successSaveAccount() throws InsufficientBalanceExceptyion, DuplicateAccountException {
		
		Account acc = new Account();
		
		acc.setAccountNumber(123);
		
		acc.setAmount(600);
		
		assertEquals(acc, accountService.createAccount(123, 600));
	}
	
	/**
	 * Test 3: check Account is already exist
	 * @throws DuplicateAccountException
	 */
	@Test(expected=com.capgemini.exception.DuplicateAccountException.class)
	public void checkDuplicateAccount() throws DuplicateAccountException,InsufficientBalanceExceptyion {
		
		Account acc = new Account();
		
		acc.setAccountNumber(123);
		
		acc.setAmount(600);
		
		accountService.createAccount(123, 600);
		
		accountService.createAccount(123, 600);
	}
	
	
	/**
	 * Test 4: deposit Amount Successfully
	 * @throws 
	 */
	@Test
	public void depositAmountSuccess() throws DuplicateAccountException,InsufficientBalanceExceptyion {
		
		Account acc = new Account();
		
		acc.setAccountNumber(123);
		
		acc.setAmount(600);
		
		accountService.createAccount(123, 600);
		
		assertEquals(700, accountService.depositAmount(123, 100));
	}
	
	/**
	 * Test 5: deposit Amount- Invalid Account
	 * @throws 
	 */
	@Test
	public void depositAmountInvalidAccount() {
		Account acc = new Account();
		
		acc.setAccountNumber(123);
		
		acc.setAmount(600);
		
		assertEquals(-1, accountService.depositAmount(126, 100));
	}
	
	/**
	 * @throws DuplicateAccountException 
	 * @throws InsufficientBalanceExceptyion 
	 * Test 6: withdrawal Amount- Invalid Account
	 * @throws 
	 */
	@Test
	public void withdrawAmount() throws InsufficientBalanceExceptyion, DuplicateAccountException {
		
		Account acc = new Account();
		
		acc.setAccountNumber(123);
		
		acc.setAmount(600);
		
		accountService.createAccount(123, 600);
		
		assertEquals(500, accountService.withdrawalAmount(123, 100));
	}
	
	/**
	 * Test 7: withdraw Amount- Invalid Account
	 * @throws 
	 */
	@Test
	public void withdrawAmountInvalidAccount() {
		Account acc = new Account();
		
		acc.setAccountNumber(123);
		
		acc.setAmount(600);
		
		assertEquals(-1, accountService.withdrawalAmount(126, 100));
	}
}
