package com.capgemini.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.beans.Account;
import com.capgemini.exception.DuplicateAccountException;

public class AccountRespositoryImpl implements AccountRespository {

	Map<Integer,Account> mapAccount = new HashMap<Integer, Account>();
	@Override
	public boolean save(Account acc) throws DuplicateAccountException {
		
		if(acc == null)//Sachin
		return false;
		
		if(mapAccount.get(acc.getAccountNumber()) != null)
			throw new DuplicateAccountException();
		
		return mapAccount.put(acc.getAccountNumber(), acc) == null ?  Boolean.FALSE : Boolean.TRUE ;
	}
	@Override
	public int addAmount(Account acc, int amount) {
		
		if(amount < 0)
			return amount;
		
		Account account = mapAccount.get(acc.getAccountNumber());
		
		if(account == null)
		{
			return -1;//Means invalid account-Account is not present
		}
		
		System.out.println("AddAmount before adding amount:"+mapAccount);
		
		int totalAmount = account.getAmount()+amount;
		
		account.setAmount(totalAmount);
		
		mapAccount.put(acc.getAccountNumber(),account);
		
		System.out.println("AddAmount After adding amount:"+mapAccount);
				
		return totalAmount;
	}
	
	@Override
	public int withdrawAmount(int acc, int amount) {
		
		if(amount < 0)
			return amount;
		
		Account account = mapAccount.get(acc);
		
		if(account == null)
		{
			return -1;//Means invalid account-Account is not present
		}
		
		System.out.println("AddAmount before adding amount:"+mapAccount);
		
		int totalAmount = 0;
		if(amount <= account.getAmount())
		{
			 totalAmount= account.getAmount() - amount;
		}
		else
		{
			//insuffucient balance
		}
		
		account.setAmount(totalAmount);
		
		mapAccount.put(acc,account);
		
		System.out.println("AddAmount After adding amount:"+mapAccount);
				
		return totalAmount;
	}


	
}
