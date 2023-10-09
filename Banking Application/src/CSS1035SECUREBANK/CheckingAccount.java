package CSS1035SECUREBANK;

public class CheckingAccount extends BankingApplication {

	private double balance;
	private double deposit;
	private String id;
	private double fee;
	private double withdrawl;

	public CheckingAccount() {

	}
	
	/**
	 * <p>This is a simple description of the method. . .
	 * <a href="http://www.MyBankIsTheGreatest.com">Bank!</a>
	 * </p>
	 * Andre Duchatellier
	 * @param id the amount of incoming damage
	 * @param deposit the amount of money you putting in
	 * @param withdrawl the amount of money you taking out
	 * @param fee the amount of money you have to pay if you overdraft
	 * secure software design that I added to this bank assignment was a overdraft exception
	 * I added a fee for the overdraft, I also added identification
	 * @see <a href="http://www.link_to_jira/HERO-402">HERO-402</a>
	 * @since 1.0
	 */
	
	
	public CheckingAccount(String id, double deposit, double withdrawl, double fee) {
		// super();
		this.id = id;
		this.deposit = deposit;
		this.withdrawl = withdrawl;
		this.fee = fee;

	}

	public String id() {
		return id;
	}

	public double deposit(int deposit) {
		setdeposit(deposit);
		return deposit;
	}

	public void setdeposit(int deposit) {
		balance += deposit;
		this.deposit = deposit;
	}

	public double withdrawl() {
		return deposit;
	}

	public void withdrawl(double withdrawl) throws OverDraftException {
		if (balance < withdrawl) {
			balance -= fee;
			throw new OverDraftException(withdrawl);
		}
		balance -= withdrawl;
		this.withdrawl = withdrawl;
	}

	public double fee() {
		return deposit;
	}

	public void fee(double fee) {
		this.fee = fee;
	}

	public double getPay() {
		return 2 * (balance + withdrawl);
	}

	public double getbalance() {
		return balance;
	}
}