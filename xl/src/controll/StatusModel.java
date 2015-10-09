package controll;

import java.util.Observable;
import util.XLException;

public class StatusModel extends Observable {
	private String statusMessage = "";
	
	public static enum State {NOTHING, NEWDATA}; 
	private State state = State.NOTHING;
	
	public StatusModel(){
	}
	
	public String getStatus() {
		return statusMessage;
	}
	
	public void setStatus(String s) {
		setChanged();
		notifyObservers();
		statusMessage = s;
	}
	
	public void setStatus(XLException e) {
		setChanged();
		notifyObservers();
		statusMessage = e.getMessage();
	}
	
	public void setState(State s) {
		this.state = s;
		setChanged();
		super.notifyObservers();
	}
	
	public State getState() {
		return state;
	}
}
