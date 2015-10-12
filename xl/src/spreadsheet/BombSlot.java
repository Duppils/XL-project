package spreadsheet;
import util.XLException;

public class BombSlot extends Slot {
	
	public BombSlot(){
	}   
	
	public double value() throws XLException {
		throw new XLException("Circular dependency detected!");
	}

	@Override
	public String toString() {
		return "BombSlot";
	}

}
