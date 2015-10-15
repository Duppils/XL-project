package controll;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import gui.SheetBase;
import gui.Editor;

import spreadsheet.*;

/*
 * This class contains the functionality for when the return key is pressed.
 */
public class ReturnListener implements KeyListener {
	
	private SheetBase sheet;
	private CurrentModel cm;
	
	public ReturnListener(SheetBase s, CurrentModel cm) {
		this.sheet = s;
		this.cm = cm;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
			Editor editor =(Editor) e.getSource();
			String s = editor.getText();
			sheet.setValue( cm.toString(), s );
		}
	}
	
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 * Not implemented!
	 */
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	//Not implemented!
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
