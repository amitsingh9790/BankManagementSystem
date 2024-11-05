package details;
import java.util.Random;

public class Transaction {
	private long transactionId;
	private double amount;
	private String type;
	private String status;
	
	public Transaction(double amount, String type,String status) {
		Random random = new Random();
		this.transactionId = 100000000000L + (long)(random.nextDouble() * 900000000000L);
		this.amount = amount;
		this.type = type;
		this.status=status;
	}

	public void printTransaction() {
		System.out.println("----------------------------------");
		System.out.println("TransactionId: "+transactionId);
		System.out.println("Transaction balance :"+amount);
		System.out.println("Account Type: "+type);
		System.out.println("Status :"+status);
	}

	public long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
}
