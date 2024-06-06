package rekeningen;

public class Spaarrekening extends Rekening {

	@Override
	public int withdraw(int amount) {
		return 0;
	}

	@Override
	public String toString() {
		return "spaarrekening[ balans = " + getBalans() + "]";
	}

	@Override
	public boolean same(Rekening r) {
		if (r instanceof Spaarrekening s) {
			return getBalans() == s.getBalans();
		}
		else return false;
	}

}
