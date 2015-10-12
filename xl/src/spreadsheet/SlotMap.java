package spreadsheet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeSet;

/**
 * @author tf08uh9
 * SlotMap is a container for a TreeSet and a HashMap for use in 
 * project XL in LTH course EDA061, fall of 2015.
 * 
 * It contains the minimum functionality of HashMap combined with a quick way of
 * returning a LinkedList of Slots for simple save, load and print operations.
 * 
 */
public class SlotMap {
	
	private HashMap<String, Slot> map = new HashMap<String, Slot>();
	private TreeSet<String> set = new TreeSet<String>();
	
	public SlotMap() {}
	
	/**
	 * Inserts a new Slot into the Map and set.
	 * @param str the key for the slot
	 * @param slot
	 */
	public void put(String str, Slot slot) {
		map.put(str, slot);
		set.add(str);
	}
	
	/**
	 * @param str the ID for the Slot to fetch.
	 * @return the Slot corresponding to ID, or NULL
	 */
	public Slot get(String str) {
		return map.get(str);
	}
	
	/**
	 * @return a linked list containing all the Slots in the map.
	 */
	public LinkedList<Slot> getList(){
		LinkedList<Slot> list = new LinkedList<Slot>();
		for ( String s: set ) {
			list.add( map.get(s) );
		}
		return list;
	}
}
