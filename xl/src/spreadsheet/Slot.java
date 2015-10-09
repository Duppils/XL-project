package spreadsheet;

public abstract class Slot {
	
//	public String toStringSave(){
//		
//	}
	
	public String toStringValue(){ //anv�nds f�r value()
		return "";
	}
	
	public String toStringExpr(){
		return "";
	}
	
	public abstract double value();

}
