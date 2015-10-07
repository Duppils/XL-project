package controll;

import java.util.Observable;


public class CurrentSlot extends Observable {
	
	String current = "A1";
	
	public CurrentModel(){}
	
	public String getCurrent(){
		return current;
	}
	
	public String toString() {
		return current;
	}
	
	public void setState(String newCurrent) {
		currentSlot = newCurrent;
		setChanged();
		notifyObservers();
	}
	
	
}
