package spreadsheet;

import java.util.Observable;

public class Status extends Observable {
	
	private String statusMessage;
	
	public Status(){
		statusMessage = "";
	}
	
	public String getStatusMessage(){
		return statusMessage;
	}
	
	public void setStatusMessage(String newMsg) {
		statusMessage = newMsg;
		setChanged();
		notifyObservers();
	}
}
