package spreadsheet;
import util.XLException;

public class BombSlot extends Slot {
	
	public BombSlot(){
	}   
	
	public double value(){
		throw new XLException("Circular dependency detected!");
	}

}
