package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenuItem;
import gui.SheetBase;;


class ClearAllMenuItem extends JMenuItem implements ActionListener {
    SheetBase sheet;
	
	public ClearAllMenuItem(SheetBase sheet) {
        super("Clear all");
        this.sheet = sheet;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clearAll();
    }
}