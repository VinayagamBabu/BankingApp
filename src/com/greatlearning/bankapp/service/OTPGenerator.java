package com.greatlearning.bankapp.service;

import com.greatlearning.bankapp.model.Customer;

public class OTPGenerator {
	
	public void generateAndSetOTP(Customer cust) {
		int otp = (int) (Math.random() * 9000) + 1000;
		System.out.println("Generated OTP Value is : "+otp);
		cust.setOtp(otp);
	}
}
