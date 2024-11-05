package account;
import details.Customer;
import details.Transaction;

public final class SavingAccount extends BankAccount{

	public SavingAccount(long accNo, double balance, int atmPin, Customer customerDetail)
	{
		super(accNo, balance, atmPin, customerDetail);
	}

	@Override
	public void deposit(double dipo_amt) {
		double curr_amt = getBalance();
		setBalance(curr_amt+dipo_amt);
		System.out.println("Transaction successful. Your new balance is: ₹" + getBalance());
		Transaction trans= new Transaction(dipo_amt, "Saving Account","Successfully deposited");
		setTransaction(trans);
	}

	@Override
	public void withdraw(double withd_amt) {
		double curr_amt = getBalance();
		if(curr_amt>=withd_amt){
			setBalance(curr_amt-withd_amt);
			System.out.println("Transaction successful. Your new balance is: ₹" + getBalance());
			Transaction trans= new Transaction(withd_amt, "Saving Account","Successfully withdraw");
			setTransaction(trans);
		}
		else {
			System.out.println("Transaction declined: Insufficient funds. Please check your account balance and try again.");
			Transaction trans= new Transaction(withd_amt, "Saving Account","failed transaction withdraw");
			setTransaction(trans);
		}
	}
	public double getInterest() {
		return getBalance()*7.5/100;
	}
}
