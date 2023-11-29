package com.greatlearning.bankapp.service;

import com.greatlearning.bankapp.model.Customer;

public class IndianBankImpl implements InternetBanking{
	
	private final float MINIMUM_BALANCE = 2000.0f;
	
	@Override
	public boolean checkCredentials(Customer cust, String enteredAccNo, String enteredPwd) {
		if(enteredAccNo != null && enteredPwd != null) {
			return enteredAccNo.equals(cust.getAccountNumber()) && 
					enteredPwd.equals(cust.getPassword());
		}
		return false;
	}

	@Override
	public float getCustomerBalance(Customer cust) {
		float balance = cust.getBalance();
		if(balance < MINIMUM_BALANCE) {
			System.out.println("Please maintain a minimum balance : "+ MINIMUM_BALANCE);
		}
		return balance;
	}

	@Override
	public void deposit(Customer cust, float amount) {
		if(amount < 0) {
			System.out.println("Deposit Failed : Invalid Deposit Amount "+amount);
			return;
		}
		float balance = cust.getBalance();
		float newBalance = balance + amount;
		cust.setBalance(newBalance);
		System.out.println("Deposit success , New Balance : "+ newBalance);
	}

	@Override
	public void withdraw(Customer cust, float amount) {
		float balance = cust.getBalance();
		if(amount > balance) {
			System.out.println("Withdrawl Failed : Insufficient Balance "+balance);
			return;
		}
		float newBalance = balance - amount;
		cust.setBalance(newBalance);
		System.out.println("Withdrawl success , New Balance : "+ newBalance);
		
	}

	@Override
	public void transfer(Customer fromCust, Customer toCust, float amount, int enteredOtp) {
		float fromBalance = fromCust.getBalance();
		if(amount > fromBalance) {
			System.out.println("Transfer Failed : Insufficient Balance "+fromBalance);
			return;
		}
		
		if(enteredOtp != fromCust.getOtp()) {
			System.out.println("Transfer Failed :  Invalid OTP "+enteredOtp);
			return;
		}
		
		float newFromBalance = fromBalance - amount;
		fromCust.setBalance(newFromBalance);
		float toBalance = toCust.getBalance();
		float newtoBalance = toBalance + amount;
		toCust.setBalance(newtoBalance);
		System.out.println("Transfer success , New Balance : "+ newFromBalance);
		
	}

}
