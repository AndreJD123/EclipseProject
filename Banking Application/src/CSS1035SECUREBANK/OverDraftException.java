package CSS1035SECUREBANK;
public class OverDraftException extends Exception {
	private double amount;

	/** Construct an exception */
	public OverDraftException(double amount) {
		super("Invalid draft " + amount);
		this.amount = amount;
	}

	/** Return the radius */
	public double getamount() {
		return amount;
	}
}
