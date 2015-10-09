package gui;

import java.util.HashMap;
import java.util.Observable;

import util.XLException;

public class TestSheet extends SheetBase{
	private HashMap<String, String> map = new HashMap<String, String>();
	
	
	public TestSheet(){
		map.put("A1", "1");
		map.put("A2", "2");
		map.put("A3", "3");
		map.put("B1", "1");
		map.put("B2", "2");
	}

	private void generateMsg(String func) {
		System.out.println( "This is TestSheet, my function " + func + " was just called!" );
	}
	private void generateMsg(String func, String args) {
		System.out.println( "This is TestSheet, my function " + func + " was just called with argument " + args);
	}
	
	public String getValue(String name) {
		generateMsg("getValue", name);
		try {
			return map.get(name).toString();
		} catch (NullPointerException e) {
			return "";
		}
	}
	
	public void setValue(String name, String textInput){
		generateMsg("setValue", "[ " + name + " , " + textInput + " ]");
		map.put(name, textInput);
		setChanged();
		notifyObservers();
		System.out.println("setValue returns!");
	}
	
	public double value(String name) {
		generateMsg("value", name);
		try {
			return Double.parseDouble( map.get(name) );
		} catch (NullPointerException e) {
			return 0;
		}
	}
	
	public void save(String filename) {
		generateMsg("save");
		return;
	}

	@Override
	public void load(String filename) throws XLException {
		generateMsg("load");
		return;
		
	}
	
}
