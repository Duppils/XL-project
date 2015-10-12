package spreadsheet;

public abstract class Slot {
	
	//Ska vi ha flera toString-metoder, t.ex. för att skriva ut hela expr eller bara värdet av den?
	// ex "#Hej" i statusfältet och "Hej" i själva sloten.
	public abstract String toString();
	
	public abstract double value();
	// hashcode-metod?
}
