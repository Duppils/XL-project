package controll;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import gui.SheetBase;

/**
 * @author tf08uh9
 * Control class is a container for the different models and listeners used for the GUI.
 * Provides functionality to send the Control object around, instead of several listeners.
 * 
 */
public class Control {
	
	private CurrentModel cm = new CurrentModel();
	private ReturnListener rl;
	
	public Control(SheetBase sheet){
		rl = new ReturnListener(sheet, cm);
	}
	
	
	/**
	 * Sends a reference to the class's ReturnListener object.
	 * @return a ReturnListener
	 */
	public KeyListener getKeyListener() {
		return rl;
	}
	
	/**
	 * Sends a reference to the  CurrentModel that is in use in this class.
	 * @return a CurrentModel
	 */
	public CurrentModel getCurrentModel(){
		return cm;
	}
}