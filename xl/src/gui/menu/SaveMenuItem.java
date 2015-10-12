package gui.menu;

import gui.StatusLabel;
import gui.XL;

import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import util.XLException;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel) {
        super(xl, statusLabel, "Save");
    }

    protected void action(String path) throws FileNotFoundException {
        try {
        	File f = new File(path);
        	f.createNewFile();
        	xl.getSheet().save(f);
        } catch (Exception e) {
        	throw new FileNotFoundException("File " + path + " not found!");
        }
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}