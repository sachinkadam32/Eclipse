package com.capgemini.repository;

import com.capgemini.beans.Account;
import com.capgemini.exception.DuplicateAccountException;

public interface AccountRespository {
	
	public boolean save(Account acc) throws DuplicateAccountException;
	
	public int addAmount(Account acc, int amount);
	
	public int withdrawAmount(int acc, int amount);

}
