package gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import spreadsheet.Status;


public class StatusLabel extends ColoredLabel implements Observer {
	Status status;
	
    public StatusLabel(SheetBase sheet) {
        super("", Color.WHITE);
        status = sheet.getStatus();
        status.addObserver(this);
    }

    public void update(Observable observable, Object object) {
        setText( status.getStatusMessage() );
    }
}