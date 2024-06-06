package rekeningen;

public abstract class Rekening {
	
	private int balans;
	
	public int getBalans() {
		return balans;
	}
	
	public Rekening() {
		balans = 0;
	}
	/**
	 * @post | getBalans() == balans
	 */
	protected void setBalans(int balans) {
		this.balans = balans;
	}
	/**
	 * @pre | 0 <= amount
	 * @post | getBalans() == old(getBalans()) + amount
	 */
	public void deposit(int amount) {
		balans += amount;
	}
	/**
	 * @pre | 0 <= amount
	 * @post | 0 <= result
	 * @post | result <= amount
	 * @post | getBalans() == old(getBalans()) - result
	 */
	public abstract int withdraw(int amount);
	/**
	 * @post | result != null
	 */
	public abstract String toString();
	/**
	 * @inspects | this, r
	 * @pre | r != null
	 * @post | !result || getBalans() == r.getBalans()
	 */
	public abstract boolean same(Rekening r);
}
