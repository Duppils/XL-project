package gui;

import java.awt.Color;
import java.util.*

import controll.*;

public class CurrentLabel extends ColoredLabel implements Observer {
	
	CurrentModel cm;
	
    public CurrentLabel(Control c) {
        super("A1", Color.WHITE);
        cm = c.getCurrentModel();
        cm.addObserver(this)
    }
    
    public void update(Observable o, Object arg){
    	setText(cm.getState());
    }
}