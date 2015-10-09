package controll;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import gui.SheetBase;

public class Control {
	
	private CurrentModel cm = new CurrentModel();
	private StatusModel sm = new StatusModel();
	private ReturnListener rl;
	
	public Control(SheetBase sheet){
		rl = new ReturnListener(sheet, cm);
	}
	
	public MouseListener getMouseListener(){
		return null;
	}
	
	public KeyListener getKeyListener() {
		return rl;
	}
	
	public CurrentModel getCurrentModel(){
		return cm;
	}
	
	public StatusModel getStatusModel() {
		return sm;
	}
}
