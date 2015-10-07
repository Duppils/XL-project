package controll;

import java.util.Observable;


public class CurrentModel extends Observable {
	
	String current = "A1";
	
	public CurrentModel(){}
	
	public String getState(){
		return current;
	}
	
	public String toString() {
		return current;
	}
	
	public void setState(String newCurrent) {
		current = newCurrent;
		setChanged();
		notifyObservers();
	}
	
	
}
