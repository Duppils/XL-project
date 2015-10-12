package spreadsheet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

public class SlotMap {
	
	private HashMap<String, Slot> map = new HashMap<String, Slot>();
	private TreeSet<String> set = new TreeSet<String>();
	
	public SlotMap() {
	}
	
	public void put(String str, Slot slot) {
		map.put(str, slot);
		set.add(str);
	}
	
	public Slot get(String str) {
		return map.get(str);
	}
	
	public LinkedList<Slot> getList(){
		LinkedList<Slot> list = new LinkedList<Slot>();
		for ( String s: set ) {
			list.add( map.get(s) );
		}
		return list;
	}
}
