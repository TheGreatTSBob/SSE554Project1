package banking;


public abstract class Account {
	
	
	protected double balance;
	protected String holder;
	protected String password;
	protected double rate = .2;
	
	protected enum CompoundResult{
		NONE,
		RATE,
		PENALTY
	};
	
	public Account(double balance, String holder, String password)
	{
		this.balance = balance;
		this.holder = holder;
		this.password = password;
	}
	
	public void deposit(double amount, String password)
	{
		if(!authenticate(password))
			return;
		
		if(amount > 0)
			balance += amount;
	}
	
	public abstract void withdraw(double amount, String password);
	
	public Double getBalance(String password)
	{
		if(authenticate(password))
			return balance;

		return null;
	}

	public Boolean isOverdrawn(String password)
	{
		if(authenticate(password))
			return balance < 0;
		
		return null;
	}
	
	protected abstract CompoundResult compoundInterest();
	
	
	public Boolean authenticate(String password)
	{
		if(this.password.compareTo(password) == 0)
			return true;		
		return false;
	}
	
}
