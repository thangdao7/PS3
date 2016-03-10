package Account;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class Test {
	
	private static int id;
	private static double balance;
	private static double annualInterestRate;
	private static double withdrawAmount;
	private static double depositAmount;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		id = 1122;
		balance = 20000;
		annualInterestRate = 4.5;
		withdrawAmount = 2500;
		depositAmount = 3000;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@org.junit.Test
	public void test_ArgConstructor() throws InsufficientFundsException{
		
		try{
		
		//Create new constructor of Account
		Account newAccount = new Account(id, balance);
		//Create no args constructor of Account
		Account noArgsAccount = new Account();
		
		//Set interest rate = 4.5%
		newAccount.setAnnualInterestRate(annualInterestRate);
		
		//Test values
		assertEquals(newAccount.getId(), id);
		assertEquals(newAccount.getBalance(), balance, 0);
		assertEquals(newAccount.getAnnualInterestRate(), annualInterestRate, 0);
		assertEquals(newAccount.getMonthlyInterestRate(), annualInterestRate / 12, 0);
			
		noArgsAccount.setId(id);
		noArgsAccount.setBalance(balance);
		
		
		//Test withdraw method
		newAccount.withdraw(withdrawAmount); //20000 - 2500 = 17500
		assertEquals(newAccount.getBalance(), 17500, 0);
		
		//Test deposit method
		newAccount.deposit(depositAmount); // 17500 + 3000 = 20500
		assertEquals(newAccount.getBalance(), 20500, 0);
		
		//Test date created method
		System.out.println(newAccount.getDateCreated());	
		
		//Test insufficient funds exception
		newAccount.withdraw(21000);
		
		} catch(InsufficientFundsException e){
			System.out.println(e.getAmount());
		}
		
	}


	
	
	
	
	
	
	
	
	
}
