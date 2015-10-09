package gui;

import java.util.Observable;

import expr.Environment;
import util.XLException;

public abstract class SheetBase extends Observable implements Environment {
	public abstract double value(String name); // inherited from Environment
	
	public abstract String getValue(String name) throws XLException;
	public abstract void setValue(String name, String textInput) throws XLException;
	
	public abstract void save(String filename) throws XLException;
	public abstract void load(String filename) throws XLException;
	
	public String toString() {
		return "SheetBase";
	}
}
