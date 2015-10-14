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
	CurrentModel cm;
	
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
		try {
			// currentmodel var det som uppdaterats.
			CurrentModel cm1 = (CurrentModel) o;
			setText( sheet.getFormatedValue( cm.getState() ) );
		} catch (Exception e) {
			// det var inte cm, utan då var det sheet istället...
			setText( sheet.getFormatedValue( cm.getState() ) );
		}
		
	}
}