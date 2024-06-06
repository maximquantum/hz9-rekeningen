package rekeningen;

/**
 * @invariant | getBalans >= -getLimiet()
 */
public class Zichtrekening extends Rekening {
	/**
	 * @invariant | getBalans >= -limiet
	 */
	private int limiet;

	/**
	 * @pre | 0 <= limiet
	 * @post | getLimiet() == limiet
	 */
	public Zichtrekening(int limiet) {
		this.limiet = limiet;
	}

	public int getLimiet() {
		return limiet;
	}
	
	/**
	 * @pre | 0 <= amount
	 * @post | result == Math.min(amount,getBalans()+getLimiet())
	 * @post | getBalans() == old(getBalans()) - result
	 */
	@Override
	public int withdraw(int amount) {
		int result = Math.min(amount,getBalans()+getLimiet());
		setBalans(getBalans() - result);
		return 0;
	}

	@Override
	public String toString() {
		return "zichtrekening[ balans = " + getBalans() + ", limiet = " + getLimiet() + "]";
	}

	@Override
	public boolean same(Rekening r) {
		if (r instanceof Zichtrekening z) {
			return getBalans() == z.getBalans() && getLimiet() == z.getLimiet();
		}
		else return false;
	}

}
