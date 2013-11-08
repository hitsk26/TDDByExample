import static org.junit.Assert.*;

import org.junit.Test;


public class SumTest {

	@Test
	public void testReduceSum(){
		Expression sum = new Sum(Money.dollar(3),Money.dollar(4));
		Bank bank = new Bank();
		Money result = bank.reduce(sum,"USD");
		assertEquals(Money.dollar(7), result);

	}
	@Test
	public void testReduceMoney() throws Exception {
		Bank bank = new Bank();
		Money result = bank.reduce(Money.dollar(1),"USD");
		assertEquals(Money.dollar(1), result);
	}
	@Test
	public void testReduceMoneyDifferentCurrency() throws Exception {
		Bank bank = new Bank();
		bank.addRate("CHF","USD",2);
		Money result = bank.reduce(Money.franc(2), "USD");
		assertEquals(Money.dollar(1), result);
	}
	@Test
	public void testArrayEquals() throws Exception {
		assertEquals(new Object[] {"abc"}, new Object[] {"abc"});
	}
	@Test
	public void testIdentitiyRate() throws Exception {
		assertEquals(1, new Bank().rate("USD", "USD"));
	}
}
