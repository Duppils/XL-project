package gui;

import java.awt.Color;
import javax.swing.JTextField;
import controll.Control;
import controll.CurrentModel;

import java.util.Observable;
import java.util.Observer;
import controll.*;

public class Editor extends JTextField implements Observer {
	private SheetBase sheet;
	private CurrentModel cm;
	
    public Editor(SheetBase sheet, Control c) {
    	this.sheet = sheet;
    	this.cm = c.getCurrentModel();
    	addKeyListener( c.getKeyListener() );
        setBackground(Color.WHITE);
        
        cm.addObserver(this);
        sheet.addObserver(this);
    }
    
    public String toString(){
    	return "Editor";
    }

	@Override
	public void update(Observable o, Object arg) {
		setText( sheet.getFormatedValue( cm.getState() ) );
	}
}