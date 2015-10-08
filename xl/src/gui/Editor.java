package gui;

import java.awt.Color;
import javax.swing.JTextField;
import controll.Control;
import controll.CurrentModel;

import java.util.Observable;
import java.util.Observer;
import controll.*;

public class Editor extends JTextField implements Observer {
	SheetBase sheet;
	
    public Editor(SheetBase sheet, Control c) {
    	this.sheet = sheet;
    	addKeyListener( c.getKeyListener() );
        setBackground(Color.WHITE);
        c.getCurrentModel().addObserver(this);
    }
    
    public String toString(){
    	return "Editor";
    }

	@Override
	public void update(Observable o, Object arg) {
		CurrentModel cm = (CurrentModel) o;
		setText( sheet.getValue( cm.getState() ) );
	}
}