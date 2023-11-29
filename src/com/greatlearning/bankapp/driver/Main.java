package com.greatlearning.bankapp.driver;

import java.util.Scanner;

import com.greatlearning.bankapp.model.Customer;
import com.greatlearning.bankapp.service.IndianBankImpl;
import com.greatlearning.bankapp.service.InternetBanking;
import com.greatlearning.bankapp.service.OTPGenerator;

public class Main {

	public static void main(String[] args) {
		
		Customer cust1 = new Customer();
		cust1.setAccountNumber("040123");
		cust1.setPassword("hardpassword");
		cust1.setBalance(5000);
		
		Customer cust2 = new Customer();
		cust2.setAccountNumber("040124");
		cust2.setPassword("hardpassword");
		cust2.setBalance(50000);
		
		InternetBanking ib = new IndianBankImpl(); //new IndianBankImpl2();
		OTPGenerator otpGen = new OTPGenerator();
		
		Scanner sc = new Scanner(System.in);
		//Supports only login for cust1
		System.out.println("Please enter the cust1 account number and password");
		String accNo = sc.nextLine();
		String pwd = sc.nextLine();
		
		if(ib.checkCredentials(cust1, accNo, pwd)) {
			//proceed with other options
			int option = 0;
			do {
				System.out.println("----------------------------------");
				System.out.println("1) CheckBalance");
				System.out.println("2) Withdraw");
				System.out.println("3) Deposit");
				System.out.println("4) Transfer");
				System.out.println("0) Logout");
				System.out.println("----------------------------------");
				System.out.println("Please enter the option");
				option = sc.nextInt();
				switch(option){
					case 1:
						System.out.println("Customer Balance is :"+ ib.getCustomerBalance(cust1));
						break;
					case 2:
						System.out.println("Please enter the withdraw amount");
						float amount  = sc.nextFloat();
						ib.withdraw(cust1, amount);
						break;
					case 3:
						System.out.println("Please enter the deposit amount");
						float amount1  = sc.nextFloat();
						ib.deposit(cust1, amount1);
						break;
					case 4:
						System.out.println("Please enter the transfer amount");
						float amount2  = sc.nextFloat();
						otpGen.generateAndSetOTP(cust1);
						System.out.println("Please enter the transfer OTP");
						int otp = sc.nextInt();
						ib.transfer(cust1, cust2, amount2, otp);
						break;
					case 0:
						System.out.println("Logged Out");
						break;
					default:
						System.out.println("Invalid Option");
				}
			}while(option !=0);
		}else {
			System.out.println("Invalid credentials.");
		}
		
		sc.close();
	}

}
