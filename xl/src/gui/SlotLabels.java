package gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingConstants;
import spreadsheet.*;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;

    /*
     * Borde inte den här ha en sheet som inparameter också?
     */
    public SlotLabels(int rows, int cols) {
        super(rows + 1, cols);
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel();
                add(label);
                labelList.add(label);
            }
        }
        SlotLabel firstLabel = labelList.get(0);
        firstLabel.setBackground(Color.YELLOW);
    }
    
    public void update(Observable o, Object arg) {
    	try {
    		Sheet s = (Sheet) o;
    		updateLabels(s);
    	} catch (Exception e) {
    		System.out.println("An error occured of unknown type in SlotLabels.update() ");
    	}
    }
    
    private void updateLabels(Sheet s) {
    	int index = 0;
    	for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                String value = s.getValue( Character.toString(ch) + Integer.toString(row) );
                list.get(index).setText(value);
                index++;
            }
        }
    }
}
