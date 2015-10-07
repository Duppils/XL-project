package spreadsheet;

public abstract class Slot {
	private String name;
	
	public Slot(String name, String input){
		this.name = name;
	}
	
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
