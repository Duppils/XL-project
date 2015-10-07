package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import controll.Control;

public class StatusPanel extends BorderPanel {
	
    protected StatusPanel(StatusLabel statusLabel, Control c) {
        add(WEST, new CurrentLabel(c));
        add(CENTER, statusLabel);
    }
}