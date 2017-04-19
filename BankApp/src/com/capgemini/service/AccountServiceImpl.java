package com.capgemini.service;

import com.capgemini.beans.Account;
import com.capgemini.exception.DuplicateAccountException;
import com.capgemini.exception.InsufficientBalanceExceptyion;
import com.capgemini.repository.AccountRespository;
import com.capgemini.repository.AccountRespositoryImpl;

public class AccountServiceImpl implements AccountService {
	
	AccountRespository accountRespository = new AccountRespositoryImpl();
	
	/* (non-Javadoc)
	 * @see com.capgemini.service.AccountService#createAccount(int, int)
	 */
	@Override
	public Account createAccount(int accNum, int amount) throws InsufficientBalanceExceptyion, DuplicateAccountException
	{
		if(amount < 500)
		{
			throw new InsufficientBalanceExceptyion();
		}
		
		Account acc = new Account();
		
		acc.setAccountNumber(accNum);
		acc.setAmount(amount);
		
		accountRespository.save(acc);
		return acc;
	}

	@Override
	public int depositAmount(int accNum, int amount) {
		
		Account acc= new Account();
		acc.setAccountNumber(accNum);
		acc.setAmount(amount);
		return accountRespository.addAmount(acc, amount);
	}

	@Override
	public int withdrawalAmount(int accNum, int amount) {

		return accountRespository.withdrawAmount(accNum, amount);
		
	}

}
