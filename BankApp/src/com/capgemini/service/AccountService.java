package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exception.DuplicateAccountException;
import com.capgemini.exception.InsufficientBalanceExceptyion;

public interface AccountService {

	Account createAccount(int accNum, int amount) throws InsufficientBalanceExceptyion, DuplicateAccountException;
	
	int depositAmount(int accNum, int amount);
	
	int withdrawalAmount(int accNum, int amount);
}