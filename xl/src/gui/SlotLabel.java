package gui;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import controll.*;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	
	private final String ID;
	private CurrentModel cm;
	
    public SlotLabel(String ID, Control c) {
    	super("                    ", Color.WHITE, RIGHT);
    	this.ID = ID;
    	cm = c.getCurrentModel();
    	cm.addObserver(this);
    	addMouseListener(this);
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
    	if ( !cm.getState().equals(ID) ) {
    		setBackground(Color.WHITE);
    	} else {
    		setBackground(Color.YELLOW);
    	}
    }

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
    
}