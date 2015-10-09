package gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import controll.Control;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, Control c, SheetBase sheet) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, c, sheet));
    }
}