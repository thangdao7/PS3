package Account;

import java.util.Date;


public class Account {
	
	
	private int id;
	private double balance;
	private double annualInterestRate;
	private Date dateCreated;
	
	//No-arg constructor
	public Account(){
		this.id = 0;
		this.balance = 0;
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	//Constructor with specified id and initial balance
	public Account(int id, double balance){
		this.id = id;
		this.balance = balance;	
		this.annualInterestRate = 0;
		this.dateCreated = new Date();
	}
	
	//Accessor for id
	public int getId() {
		return id;
	}

	//Mutator for id
	public void setId(int id) {
		this.id = id;
	}

	//Accessor for balance
	public double getBalance() {
		return balance;
	}
	
	//Mutator for balance
	public void setBalance(double balance) {
		this.balance = balance;
	}

	//Accessor for interest rate
	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	//Mutator for interest rate
	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}

	//Accessor for date created
	public Date getDateCreated(){
		return dateCreated;
	}
	
	//Returns monthly interest rate
	public double getMonthlyInterestRate(){
		return this.annualInterestRate / 12.0;
	}
	
	//Withdraw specified amount from account
	public void withdraw(double amount) throws InsufficientFundsException{
		if(this.balance >= amount){
			this.balance -= amount;
		}	else 
				throw new InsufficientFundsException(amount - this.balance);	
	}
	
	//Deposit specified amount to account
	public void deposit(double amount){
		this.balance += amount;
	}

}
