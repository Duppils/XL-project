package gui;

import java.awt.Color;
import java.awt.event.*;
import java.util.*;
import controll.*;
import java.awt.Dimension;

public class SlotLabel extends ColoredLabel implements MouseListener, Observer {
	
	private final String ID;
	private CurrentModel cm;
	private final String WIDTHSTRING = "                    ";
	
    public SlotLabel(String ID, Control c) {
    	super(" ", Color.WHITE, RIGHT);
    	setPreferredSize( new Dimension(60, 15) );
    	this.ID = ID;
    	cm = c.getCurrentModel();
    	if (cm.getState().equals(this.ID)) {
    		setBackground(Color.YELLOW);
    	}
    	cm.addObserver(this);
    	addMouseListener(this);
    }
    
    /*
     * Inherited from ActionListener
     */
    public void ActionPerformed(ActionEvent e) {
    	return;
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		System.out.println("This is SlotLabel: " + ID + ". I've been clicked by a mouse!");
    	cm.setState(ID);
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