package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;
import spreadsheet.*;
import controll.*;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private final int ROWS;
    private final int COLS;
    private SheetBase sheet;

    /*
     * Borde inte den här ha en sheet som inparameter också?
     */
    public SlotLabels(int rows, int cols, Control c, SheetBase sheet) {
        super(rows + 1, cols);
        this.ROWS = rows;
        this.COLS = cols;
        this.sheet = sheet;
        
        labelList = new ArrayList<SlotLabel>(ROWS * COLS);
        for (char ch = 'A'; ch < 'A' + COLS; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= ROWS; row++) {
            for (char ch = 'A'; ch < 'A' + COLS; ch++) {
            	String ID = generateID(row, ch);
                SlotLabel label = new SlotLabel(ID, c);
                add(label);
                labelList.add(label);
            }
        }
        this.sheet.addObserver(this);
        updateLabels(this.sheet);
    }
    
    public void update(Observable o, Object arg) {
    	updateLabels(sheet);
    }
    
    private void updateLabels(SheetBase s) {
    	int index = 0;
    	for (int row = 1; row <= ROWS; row++) {
            for (char ch = 'A'; ch < 'A' + COLS; ch++) {
                String value = s.getValue( generateID(row, ch) );
                labelList.get(index).setText(value);
                index++;
            }
        }
    }
    
    private String generateID(int row, char ch) {
    	return Character.toString(ch) + Integer.toString(row);
    }
}
