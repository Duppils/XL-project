package controll;

import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import gui.SheetBase;
import gui.Editor;

import spreadsheet.*;

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
			System.out.println("This is ReturnListener.keyPressed(), source was; " + e.getSource().toString() );
			Editor editor =(Editor) e.getSource();
			String s = editor.getText();
			sheet.setValue( cm.toString(), s );
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
