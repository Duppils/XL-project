package gui;

import java.awt.Color;
import java.awt.event;
import java.util.*;

public class SlotLabel extends ColoredLabel implements ActionListener, Observer {
	
	private final String ID;
	private CurrentModel cm;
	
    public SlotLabel(String ID, Control c) {
    	this.ID = ID;
    	cm = c.getCurrentModel();
    	cm.addObserver(this);
    	
    	addActionListener(this);
        super("                    ", Color.WHITE, RIGHT);
    }
    
    /*
     * Inherited from ActionListener
     */
    public void ActionPerformed(ActionEvent e) {
    	cm.setState(ID);
    }
    
    /*
     * Inherited from Observer
     */
    public void update(Observable observable, Object o) {
    	if ( !cm.getCurrent().equals(ID) ) {
    		setBackground(Color.WHITE);
    	} else {
    		setBackground(Color.YELLOW);
    	}
    }
    
    
}