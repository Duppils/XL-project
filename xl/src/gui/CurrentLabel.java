package gui;

import java.awt.Color;
import java.util.*;

import controll.*;

public class CurrentLabel extends ColoredLabel implements Observer {
	
    public CurrentLabel(Control c) {
        super("A1", Color.WHITE);
        CurrentModel cm = c.getCurrentModel();
        cm.addObserver(this);
    }
    
    public void update(Observable o, Object arg){
    	CurrentModel cm = (CurrentModel) o;
    	setText(cm.getState());
    }
}