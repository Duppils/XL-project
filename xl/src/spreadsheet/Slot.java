package spreadsheet;

public abstract class Slot {
	private String name;
	
	public Slot(String name, String input){
		this.name = name;
	}
	
//	public String toStringSave(){
//		
//	}
	
	public String toStringValue(){ //används för value()
		
	}
	
	public String toStringExpr();
	
	public abstract double value();

}
