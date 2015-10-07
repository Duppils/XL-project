package spreadsheet;

import java.util.HashMap;
import java.util.Observable;

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
	
	public void setValue(String name, String textInput){
		map.put(name, sb.build(textInput, ""));
	}
	
	@Override
	public double value(String name) {
		return map.get(name).value();
	}

}
