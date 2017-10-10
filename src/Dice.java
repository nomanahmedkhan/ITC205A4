public class Dice {
			
	private DiceValue value;
	
	public Dice() {
		value =  DiceValue.getRandom();
	}
	
	public Dice (DiceValue val){
		this.value = val;
	}
	
	public DiceValue getValue() {
		return value;
	}

	public void roll() {
		value = DiceValue.getRandom();
	}		
	
	
	public String toString() {
		return value.toString();
	}
}
