package spreadsheet;

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

	public String getValue(String name){
		return map.get(name).toString();
	}
	
	public void setValue(String name, String input){
		try{
			map.put(name, sb.buildBomb());
		}catch(XLException e){
			
		}
		map.put(name, sb.build(input));
	}
	
	@Override
	public double value(String name) {
		return map.get(name).value();
	}

}
