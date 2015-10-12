package spreadsheet;

public abstract class Slot {
	
	public abstract String toString(); //slots in GUI
	
	public abstract String formattedToString(); //String in editor
	
	public abstract double value();
	
//	public abstract int hashCode();
}
