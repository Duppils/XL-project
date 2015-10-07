package controll;

import java.util.Observable;
import util.XLException;

public class StatusModel extends Observable {
	private String statusMessage = "";
	
	public StatusModel(){
		
	}
	
	public void setStatus(String s) {
		statusMessage = s;
	}
	
	public void setStatus(XLException e) {
		statusMessage = e.getMessage();
	}
}
