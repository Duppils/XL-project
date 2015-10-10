package spreadsheet;

public abstract class Slot {
	
//	public String toStringSave(){
//		
//	}
	
	public String toStringValue(){
		return "";
	}
	
	public String toStringExpr(){
		return "";
	}
	
	public abstract double value();

}
