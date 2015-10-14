package gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observer;

import javax.swing.JMenuItem;
import controll.*;
import gui.SheetBase;;


class ClearMenuItem extends JMenuItem implements ActionListener {
	
	CurrentModel cm;
	SheetBase sheet;
	
    public ClearMenuItem(Control c, SheetBase s) {
        super("Clear");
        cm = c.getCurrentModel();
        this.sheet = s;
        addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        sheet.clear(cm.getState());
    }
}