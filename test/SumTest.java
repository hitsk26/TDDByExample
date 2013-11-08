import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class SumTest {
	Expression fiveBucks;
	Expression tenFrancs;
	Bank bank;

	@Before
	public void before() {
		fiveBucks = Money.dollar(5);
		tenFrancs = Money.franc(10);
		bank = new Bank();
		bank.addRate("CHF","USD",2);
	}

	@Test
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
		Money result = bank.reduce(sum,"USD");
		assertEquals(Money.dollar(7), result);

	}
	@Test
	public void testReduceMoney() throws Exception {
		Money result = bank.reduce(Money.dollar(1),"USD");
		assertEquals(Money.dollar(1), result);
	}
	@Test
	public void testReduceMoneyDifferentCurrency() throws Exception {
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	@Test
	public void testIdentitiyRate() throws Exception {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
	@Test
	public void testMixAddition() throws Exception {
		Money result = bank.reduce(fiveBucks.plus(tenFrancs),"USD");
		assertEquals(Money.dollar(10), result);
	}
	@Test
	public void testSumPlusMoney() throws Exception {
		Expression sum = new Sum(fiveBucks,tenFrancs).plus(fiveBucks);
		Money result = bank.reduce(sum,"USD");
		assertEquals(Money.dollar(15), result);
	}
	@Test
	public void testSumTimes() throws Exception {
		Expression sum = new Sum(fiveBucks,tenFrancs).times(2);
		Money result = bank.reduce(sum, "USD");
		assertEquals(Money.dollar(20), result);
	}
}
