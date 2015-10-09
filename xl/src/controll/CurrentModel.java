package controll;

import java.util.Observable;


public class CurrentModel extends Observable {
	
	private String current = "A1";
	
	public CurrentModel(){}
	
	public String getState(){
		return current;
	}
	
	public void setState(String newCurrent) {
		current = newCurrent;
		setChanged();
		notifyObservers();
	}
	
	public String toString() {
		return current;
	}
	
}
