package bank;
import account.BankAccount;
import account.CurrentAccount;
import account.SavingAccount;
import details.Customer;
import details.Transaction;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Bank {
	private static ArrayList<BankAccount> data = new ArrayList<>();
    /**
     * @param type Saving Account/Current Account
     * @param accNo Account Number
     * @return object of Saving Account/Current Account
     */
	public static BankAccount createAccount(int type,long accNo){
		Scanner sc = new Scanner(System.in);

//		System.out.println("Enter Your Name: ");
//		String name = sc.nextLine();
//		System.out.println("Enter Your Age: ");
//		int age = sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter Gender: ");
//		String gender = sc.nextLine();
//		System.out.println("Enter Mobile No: ");
//		long mo = sc.nextLong();
//		System.out.println("Enter Pin Code: ");
//		int pincode = sc.nextInt();
//		System.out.println("Enter 4 digit Atm Pin: ");
//		int atmPin = sc.nextInt();
		String name = "Amit Singh";int age = 23;String gender = "Male";long mo = 8853382398L;int pincode = 273306;int atmPin = 1234;
		if(type==1) {
			SavingAccount acc = new SavingAccount(accNo,10000, atmPin, new Customer(name, age, gender, mo,pincode));
			return acc;
		}
		else if (type==2) {
			CurrentAccount acc = new CurrentAccount(accNo,10000,atmPin,new Customer(name,age,gender,mo,pincode));
			return acc;
		}
		return null;
	}
	/**
	 * To search account exist or not, if exist check atmPin
	 * @return object of Saving Account/Current Account is account number and atmPin matched
	 */
	public static BankAccount findAccount(){
		Scanner sc = new Scanner(System.in);
		long acc_No;
		int A_Pin;
		System.out.println("Enter Account No: ");
		acc_No = sc.nextLong();
		BankAccount acc = null;
		for(int i=0;i<getData().size();i++) {
			if(getData().get(i).getAccountNo()==acc_No) {
				acc = getData().get(i);
				break;
			}
		}
		if(acc== null){
			System.out.println("Account does not exist\nPlease create your account first...");
			return acc;
		}

		if(acc_No == acc.getAccountNo()) {
			System.out.println("Enter 4 digit Atm Pin: ");
			int atmPin = sc.nextInt();
			if(atmPin == acc.getAtmPin()) {
				return acc;
			}else System.out.println("You Entered Wrong Pin");
		}else {
			System.out.println("You entered wrong account No "+acc_No);
		}
		return null;
	}
	/*
	 * Takes object of ArrayList of type Transaction and print all the transaction of that user account which one want to check
	 */
	public static void printTrans(ArrayList<Transaction> tx){
		for (int i = 0; i < tx.size(); i++) {
			tx.get(i).printTransaction();
		}
	}
	public static ArrayList<BankAccount> getData() {
		return data;
	}
	public static long generateAccount() {
		Random random = new Random();
		int x;
		long accNo;
		do{
			accNo = 100000000000L + (long)(random.nextDouble() * 900000000000L);
			for(int i=0;i<data.size();++i) 
				if(accNo==data.get(i).getAccountNo())
					accNo=0;
		
		}while(accNo==0);
		return accNo;
	}
}
