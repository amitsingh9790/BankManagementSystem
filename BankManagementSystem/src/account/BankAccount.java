package account;
import java.util.ArrayList;
import details.Customer;
import details.Transaction;

public abstract sealed class BankAccount permits CurrentAccount, SavingAccount{
	private final long accountNo;
	private double balance;
	private int atmPin;
	private Customer customerDetail;
	private ArrayList<Transaction> tx = new ArrayList<Transaction>();
	
	public BankAccount(long accountNo, double balance, int atmPin, Customer customerDetail) {
		this.accountNo = accountNo;
		this.balance = balance;
		this.atmPin = atmPin;	}

	abstract public void deposit(double dipo_amt);

	abstract public void withdraw(double withd_amt);
	public long getAccountNo() {
		return accountNo;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAtmPin() {
		return atmPin;
	}

	public void setAtmPin(int atmPin) {
		this.atmPin = atmPin;
	}

	public Customer getCustomerDetail() {
		return customerDetail;
	}

	public void setCustomerDetail(Customer customerDetail) {
		this.customerDetail = customerDetail;
	}

	public ArrayList<Transaction> getTransaction() {
		return tx;
	}

	public void setTransaction(Transaction trans) {
		tx.add(trans);
	}

}
