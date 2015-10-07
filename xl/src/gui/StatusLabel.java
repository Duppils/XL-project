package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import controll.*;

public class StatusLabel extends ColoredLabel implements Observer {
	StatusModel sm;
	
    public StatusLabel(Control c) {
        super("", Color.WHITE);
        sm = c.getStatusModel();
        sm.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        setText( sm.getStatus() );
    }
}