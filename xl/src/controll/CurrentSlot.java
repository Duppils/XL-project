package controll;

import java.util.Observable;

/*
 * Att göra: implementera att den här får en lyssnare någonstans!
 **/

public class CurrentSlot implements CurrentSlotInterface {
	
	String current = "A1";
	
	public CurrentSlot(){}
	
	public String getCurrent(){
		return current;
	}
	
	public Stirng toString() {
		return current;
	}
	
	public void set(String newCurrent) {
		currentSlot = newCurrent;
		notifyObservers();
	}
	
	
}
