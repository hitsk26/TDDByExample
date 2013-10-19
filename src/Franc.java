
public class Franc {
	private int amount ;

	public Franc(int amount) {
		this.amount = amount;
	}
	Franc times(int multiplier){
		return new Franc(amount * multiplier);
//		amount = amount * 2;
	}
	@Override
	public boolean equals(Object obj) {
		Franc franc = (Franc) obj;
		return amount == franc.amount;
		//	return true;
	}

}
