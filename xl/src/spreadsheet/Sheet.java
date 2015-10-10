package spreadsheet;

import java.io.File;
import java.util.HashMap;
import java.util.Observable;

import util.XLException;
import expr.Environment;

public class Sheet extends Observable implements Environment {
	private HashMap<String, Slot> map;
	private SlotBuilder sb;
	
	public Sheet(SlotBuilder sb){
		this.sb = sb;
		map = new HashMap<String, Slot>();
	}

	public String getValue(String name){ //ändra namn
		return map.get(name).toString();
	}
	
	public void setValue(String name, String input){
		if(map.get(name) != null){
			try{
				map.put(name, sb.build(""));
			}catch(XLException e){
				System.err.println(e.getMessage());
			}
			map.put(name, sb.build(input));	
		}
	}
	
	@Override
	public double value(String name) { 
//		if(map.get(name) == null){
//			return 0;
//		}
		try{
		return map.get(name).value();
		}catch(NullPointerException e){
			System.err.println(e.getMessage());
		}
		return 0;
	}
	
	public void saveToFile(File f){
		
	}
	
	public void loadFromFile(File f){
		
	}

}
