package gui;

import java.io.File;
import java.util.Observable;

import expr.Environment;
import util.XLException;
import spreadsheet.Status;

public abstract class SheetBase extends Observable implements Environment {
	
	protected Status status = new Status();
	
	public abstract double value(String name); // inherited from Environment
	
	public abstract String getValue(String name) throws XLException;
	public abstract void setValue(String name, String textInput) throws XLException;
	
	public abstract void save(File f) throws XLException;
	public abstract void load(File f) throws XLException;
	
	public Status getStatus(){
		return status;
	}
	
	public String toString() {
		return "SheetBase";
	}
}
