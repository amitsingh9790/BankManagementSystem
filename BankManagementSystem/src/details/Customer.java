package details;

public class Customer {
	private String accountHolderName;
	private int age;
	private String gender;
	private long mobileNo;
	private int pinCode;
	
	public Customer(String accountHolderName, int age, String gender, long mobileNo, int pinCode) {
		this.accountHolderName = accountHolderName;
		this.age = age;
		this.gender = gender;
		this.mobileNo = mobileNo;
		this.pinCode = pinCode;
	}
	

	public void printCustomerDetails() {
		System.out.println("----------------------------------");
		System.out.println("AccountHolderName: "+accountHolderName);
		System.out.println("Age : "+age);
		System.out.println("Gender : "+gender);
		System.out.println("MobileNo : "+mobileNo);
		System.out.println("PinCode:  "+pinCode);
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	
}
