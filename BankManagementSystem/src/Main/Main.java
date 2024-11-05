package Main;
import java.util.Scanner;
import account.BankAccount;
import bank.Bank;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int flag=0;
		do {
			System.out.println("----------------------------------");
			System.out.println("Press the number: ");
			System.out.println("1. To Create Your Account");
			System.out.println("2. Perform Transaction");
			System.out.println("3. Change your ATM Pin");
			System.out.println("4. Check your Balance");
			System.out.println("5. Exit ");

			flag = sc.nextInt();

			switch(flag) {
			case 1:
				System.out.println("1. Saving Account\n2. Current Account \n0. Back");
				char type =  sc.next().charAt(0);
				long accNo = Bank.generateAccount();
				if(type=='1') {
					BankAccount acc = Bank.createAccount(1,accNo);
					Bank.getData().add(acc);
					System.out.println("Your account has been successfully opened...\nYour Account no is "+acc.getAccountNo()+"\n0. Home");
					sc.nextLine();sc.nextLine();
				}
				else if(type=='2') {
					BankAccount acc = Bank.createAccount(2,accNo);
					Bank.getData().add(acc);
					System.out.println("Your account has been successfully opened...\nYour Account no is "+acc.getAccountNo()+"\n0. Home");
					sc.nextLine();sc.nextLine();
				}
				else {
					break;
				}
				break;
			case 2:
				//PerformTransaction()
				System.out.println("1. Deposit\n2. Withdraw\n3. Transaction Detail\n4. Back");
				sc.nextLine();
				char x =  sc.next().charAt(0);
				//Deposit
				if(x=='1'){
					System.out.println("Enter deposit amount: ");
					double des = sc.nextDouble();
					BankAccount bankAccount = Bank.findAccount();
					if (bankAccount==null) {
						System.out.println("0. Home");
						sc.nextLine();sc.nextLine();
						break;
					}
					bankAccount.deposit(des);
					System.out.println("0. Home");
					sc.nextLine();sc.nextLine();
					break;
				}
				//Withdraw
				else if (x=='2') {
					System.out.println("Enter withdraw amount: ");
					double withr = sc.nextDouble();
					BankAccount bankAccount = Bank.findAccount();
					if (bankAccount==null) {
						System.out.println("0. Main Menu");
						sc.nextLine();sc.nextLine();
						break;
					}
					bankAccount.withdraw(withr);
					System.out.println("0. Main Menu");
					sc.nextLine();sc.nextLine();
					break;
				}
				//Transaction Detail
				else if(x=='3') {
					BankAccount bankAccount = Bank.findAccount();
					if(bankAccount!=null)
						Bank.printTrans(bankAccount.getTransaction());
					System.out.println("0. Main Menu");
					sc.nextLine();sc.nextLine();
					break;
				}
				else
					break;
			case 3:
					int newPin;
					BankAccount bankAccount = Bank.findAccount();
					if(bankAccount!=null) {
						System.out.println("Enter New Pin: ");
						newPin = sc.nextInt();
						bankAccount.setAtmPin(newPin);
					}
				break;
			case 4:
				BankAccount account = Bank.findAccount();
				if(account!=null)
					System.out.printf("Your account balance is: %.2f%n",account.getBalance());
				System.out.println("0. Main Menu");
				sc.nextLine();sc.nextLine();
				break;
			default:
				break;
			}
		}while(flag!=5);
		System.out.println("\nThank you for using our services.");
		
		sc.close();
	}
}
