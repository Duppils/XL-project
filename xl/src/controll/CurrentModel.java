package controll;

import java.util.Observable;

/*
 * This class is intended to act as a container for which slot the user have selected.
 * The preset value is slot A1, however this is changeable with the constructor.
 */
public class CurrentModel extends Observable {
	
	private String current = "A1";
	
	public CurrentModel(){}
	
	public CurrentModel(String curr) {
		this.current = curr;
	}
	
	/**
	 * @return the current state of the model. Is at this point the same as toString(),
	 * but it is kept for sake of completeness, and we may want to change the 
	 * representation to something else in the future, where toString and getState
	 * should return different results. 
	 */
	public String getState(){
		return current;
	}
	
	
	/**
	 * @param newCurrent the newState to be represented.
	 * The method notifies its observers after this call.
	 */
	public void setState(String newCurrent) {
		current = newCurrent;
		setChanged();
		notifyObservers();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return current;
	}
	
}
