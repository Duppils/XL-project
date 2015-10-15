package gui;

import java.io.File;
import java.util.Observable;

import expr.Environment;
import util.XLException;
import spreadsheet.Status;

public abstract class SheetBase extends Observable implements Environment {
	
	protected Status status = new Status();
	
	public abstract double value(String name); // inherited from Environment
	
	/*
	 * Returns a formated value string, for use in e.g. editors
	 */
	public abstract String getFormatedValue(String name) throws XLException;
	
	/*
	 * Returns a non-formated value string, i.e. for use in presentation of results
	 */
	public abstract String getValue(String name) throws XLException;
	
	
	public abstract void setValue(String name, String textInput) throws XLException;
	
	public abstract boolean clear(String name) throws XLException;
	public abstract void clearAll() throws XLException;
	
	public abstract void save(File f) throws XLException;
	public abstract void load(File f) throws XLException;
	
	public Status getStatus(){
		return status;
	}
	
	public String toString() {
		return "SheetBase";
	}
}
