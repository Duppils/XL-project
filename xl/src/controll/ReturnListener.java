package controll;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import gui.Editor;
import spreadsheet.*;

public class ReturnListener implements ActionListener {
	
	Editor ed;
	Sheet sheet;
	CurrentModel cm;
	
	public ReturnListener(Editor ed, Sheet s, CurrentModel cm) {
		this.ed = ed;
		this.sheet = s;
		this.cm = cm;
	}
	
	public void actionPerformed(ActionEvent e) {
		/*
		if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
		 
			String s = ed.getText();
			Sheet.setValue( cs.toString(), s )
			//gör någonting med s... Typ mata vidare in i modellen...
		}
		*/
	}

}
