import static org.junit.Assert.*;

import org.junit.Test;


public class DollarTest {

	@Test
	public void testMultiplication() {
		Money five = Money.dollar(5);
		assertEquals(Money.dollar(10), five.times(2));
		assertEquals(Money.dollar(15),five.times(3));
	}
	@Test
	public void testEquality() throws Exception {
		assertTrue(Money.dollar(5).equals(Money.dollar(5)));
		assertFalse(Money.dollar(5).equals(Money.dollar(6)));
		assertFalse(Money.franc(5).equals(Money.dollar(5)));
	}
	@Test
	public void testCurrency() throws Exception {
		assertEquals("USD", Money.dollar(1).currency());
		assertEquals("CHF", Money.franc(1).currency());

	}
	@Test
	public void testSimpleAddtion() throws Exception {
		Money five = Money.dollar(5);
		Expression sum = five.plus(five);
		Bank bank = new Bank();
		Money reduced = bank.reduce(sum,"USD");
		assertEquals(Money.dollar(10),reduced);
	}
	@Test
	public void testPlusRetrunsSum() throws Exception {
		Money five = Money.dollar(5);
		Expression result = five.plus(five);
		Sum sum =(Sum) result;
		assertEquals(five, sum.augend);
		assertEquals(five, sum.addend);
	}
}
