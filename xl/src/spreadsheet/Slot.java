package spreadsheet;

public abstract class Slot {
	
	
	/* 
	 * Returns a String for use in representation of slots in GUI (eg cells)
	 */
	public abstract String toString(); //slots in GUI
	
	/*
	 * Returns a formatted String for use in expression editor
	 */
	public abstract String formattedToString(); //String in editor
	
	public abstract double value();
	
}
