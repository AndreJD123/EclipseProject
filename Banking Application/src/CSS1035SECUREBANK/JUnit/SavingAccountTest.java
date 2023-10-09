package CSS1035SECUREBANK.JUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import CSS1035SECUREBANK.SavingAccount;

class SavingAccountTest {

	@Test
	void testDeposit() {
		SavingAccount sa = new SavingAccount();
		String deposit = "100";
		sa.deposit((new Integer(deposit)).intValue());
		assertEquals(100.0, sa.getbalance());
	}

	void testWithdrawl() {
		SavingAccount sa = new SavingAccount();
		String withdrawl = "100";
		sa.withdrawl((new Integer(withdrawl)).intValue());
		assertEquals(-100.0, sa.getbalance());
	}
}
