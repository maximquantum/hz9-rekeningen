package rekeningen;

abstract class Rekening {
	
	int balans;

	abstract int deposit(int amount);
	abstract int withdraw(int amount);
	

}

class Zichtrekening extends Rekening {
	
	int kredietlimiet;
	
	Zichtrekening(int kredietlimiet) {
		this.kredietlimiet = kredietlimiet;
	}

	@Override
	int deposit(int amount) {
		return 0;
	}

	@Override
	int withdraw(int amount) { 
		if (balans+kredietlimiet < amount) {
			int withdraw = balans+kredietlimiet;
			balans = -kredietlimiet;
			return withdraw;
		}
		else {
			balans -= amount;
			return amount;
		}
	}
	
}

class Spaarrekening extends Rekening {

	@Override
	int deposit(int amount) {
		return 0;
	}

	@Override
	int withdraw(int amount) {
		return 0;
	}
	
}
