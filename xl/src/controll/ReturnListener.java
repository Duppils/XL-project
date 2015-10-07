package controll
import java.awt.event;

import gui.Editor;

public class ReturnListener implements ActionListener {
	
	Editor ed;
	Sheet sheet;
	CurrentSlot cs;
	
	public ReturnListener(Editor ed, Sheet s, CurrentSlot cs) {
		this.ed = ed;
		this.spreadsheet = s;
		this.cs = cs;
	}
	
	actionPerformed(ActionEvent e) {
		if ( e.getKeyCode() == KeyEvent.VK_ENTER ) {
			String s = ed.getText();
			Sheet.setValue( cs.toString(), s )
			//gör någonting med s... Typ mata vidare in i modellen...
		}
	}

}
