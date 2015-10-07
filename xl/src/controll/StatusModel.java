package controll;

import java.util.Observable;
import util.XLException;

public class StatusModel extends Observable {
	private String statusMessage = "";
	
	public StatusModel(){
		
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
}
