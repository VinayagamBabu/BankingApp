package com.greatlearning.bankapp.service;

import com.greatlearning.bankapp.model.Customer;

public interface InternetBanking {
	boolean checkCredentials(Customer cust ,String enteredAccNo,String enteredPwd);
	float getCustomerBalance(Customer cust);
	void deposit(Customer cust,float amount);
	void withdraw(Customer cust,float amount);
	void transfer(Customer fromCust,Customer toCust, float amount,int otp);
}
