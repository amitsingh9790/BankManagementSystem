package account;

import details.Customer;
import details.Transaction;

import java.util.Random;

public final class CurrentAccount extends BankAccount{
	private final int overdraftLimit;
	private final int overdraftCharge;
	public CurrentAccount(long accNo, double balance, int atmPin, Customer customerDetail) {
		super(accNo, balance, atmPin, customerDetail);
		overdraftLimit=50_000;
		overdraftCharge=12;
	}

	@Override
	public void deposit(double depo_amt) {
		double curr_amt = getBalance();
		if(curr_amt<0) {
			setBalance(curr_amt+depo_amt-depo_amt*overdraftCharge/100);
			Transaction trans= new Transaction(depo_amt, "Current Account","Successful Deposited");
			setTransaction(trans);
		}
		else {
			setBalance(curr_amt+depo_amt);
			System.out.println("Transaction successful. Your new balance is: ₹" + getBalance());
			Transaction trans= new Transaction(depo_amt, "Current Account","Successful Deposited");
			setTransaction(trans);
		}
	}

	@Override
	public void withdraw(double withd_amt) {
		double curr_amt = getBalance();
		if(curr_amt-withd_amt>=-overdraftLimit) {
			setBalance(curr_amt - withd_amt);
			System.out.println("Transaction successful. Your new balance is: ₹" + getBalance());
			Transaction trans= new Transaction(withd_amt, "Current Account","Successful Withdraw");
			setTransaction(trans);
		}
		else {
			System.out.println("Transaction declined: You have exceeded your overdraft limit. Please adjust your withdrawal amount.");
			Transaction trans= new Transaction(withd_amt, "Current Account","failed transaction Withdraw");
			setTransaction(trans);
		}
	}
}
