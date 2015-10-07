package controll;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

public class Control {
	
	private CurrentModel cm = new CurrentModel();
	private StatusModel sm = new StatusModel();
	
	public Control(){
		
	}
	
	public MouseListener getMouseListener(){
		return null;
	}
	public KeyListener getKeyBoardListener() {
		return null;
	}
	
	public CurrentModel getCurrentModel(){
		return cm;
	}
	
	public StatusModel getStatusModel() {
		return sm;
	}
}
