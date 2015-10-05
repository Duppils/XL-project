package spreadsheet;
import util.XLException;

public class BombSlot extends Slot {
	
	public BombSlot(String name, String input){
		super(name, input);
	}
	
	public double value(){
		throw new XLException("Circular dependency detected!");
	}

}
