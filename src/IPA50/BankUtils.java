package IPA50;
import java.util.*;


class BankAccount {
	int accountNumber;
	String accountHolderName;
	double balance;
	BankAccount(int acc,String name,double bal){
		this.accountNumber=acc;
		this.accountHolderName=name;
		this.balance=bal;
	}
	public double getBalance() {return this.balance;}
	public String getName() {return this.accountHolderName;}
	public void setBalance(double bal) {
		this.balance=bal;
	}
	public String toString() {
		return this.accountHolderName+" - "+this.accountNumber+" - "+this.balance;
	}
}

class Transaction {

	String transactionCode;
	double amount;
	String timestamp;
	Transaction(String transactionCode,double amount,String timestamp){
		this.transactionCode=transactionCode;
		this.amount=amount;
		this.timestamp=timestamp;
	}
	public String getTransactionCode() {return this.transactionCode;}
	public double getAmount() {return this.amount;}
	public String getTimeStamp() {return this.timestamp;}
}

class InsufficientBalanceException extends Exception{
	InsufficientBalanceException(String message){
		super(message);
	}
}

public class BankUtils {
	static Transaction transferFunds(BankAccount fromTransfer,BankAccount toTransfer,double amount, String transactionCode)throws InsufficientBalanceException{
		Transaction trans=new Transaction(transactionCode, amount, (new Date()).toString());
		double fromAccountBalance=fromTransfer.getBalance();
		if(fromAccountBalance<amount) {
			throw new InsufficientBalanceException("Insufficient balance in the Sender Account");
		}
		double remainBal=fromAccountBalance-amount;
		fromTransfer.setBalance(remainBal);
		toTransfer.setBalance(toTransfer.getBalance()+amount);
				
		return trans;
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
			int acNum=scan.nextInt();scan.nextLine();
			String acName=scan.nextLine();
			double amnt=scan.nextDouble();
		BankAccount fromAcc=new BankAccount(acNum,acName,amnt);
			acNum=scan.nextInt();scan.nextLine();
			acName=scan.nextLine();
			amnt=scan.nextDouble();
		BankAccount toAcc=new BankAccount(acNum,acName,amnt);
		
		System.out.println("Before Transfer:");
		System.out.println("Account 1: "+fromAcc.toString());
		System.out.println("Account 2: "+toAcc.toString());
		
		double amount=scan.nextDouble();scan.nextLine();
		String transCode=scan.nextLine();
		
		try {
			Transaction trans=transferFunds(fromAcc,toAcc,amount,transCode);
				
			System.out.println("After Transfer:");
			System.out.println("Account 1: "+fromAcc.toString());
			System.out.println("Account 2: "+toAcc.toString());
		
			System.out.println("Transaction Details:");
			System.out.println("Transaction Code: "+trans.getTransactionCode());
			System.out.println("Amount Transferred: "+trans.getAmount());
			System.out.println("Timestamp: "+trans.getTimeStamp());
		}catch(InsufficientBalanceException ee) {
			System.out.println(ee.toString());
		}
		
		scan.close();
	}
}
