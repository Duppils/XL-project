package spreadsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import util.XLException;
import gui.SheetBase;

/*
 * Kvar att göra i sheet:
 * - Lösa så att vi kan ta bort slots som inte refereras från någon annan slot.
 * - division med noll i "andra hand"
 */

public class Sheet extends SheetBase {
	private SlotMap map;
	private SlotBuilder sb;

	public Sheet() {
		sb = new SlotBuilder(this);
		map = new SlotMap();
	}

	public String getValue(String name) throws XLException {
		try {
			return map.get(name).toString();
		} catch (NullPointerException e) {
			return "";
		}
	}
	
	public String getFormatedValue(String name) throws XLException {
		try {
			return map.get(name).formattedToString();
		} catch (NullPointerException e) {
			return "";
		}
	}

	public void setValue(String name, String input) throws XLException {
		if ( checkInput(input) ) {
			Slot oldSlot = map.get(name);
			Slot newSlot = sb.build(input);
			try {
				map.put(name, sb.buildBomb());
				newSlot.value();
				map.put(name, sb.build(input));
			} catch (Exception e) {
				System.out.println("Exception fångat i setValue rad 45");
				if (oldSlot != null) {
					map.put(name, oldSlot);
				}
				status.setStatusMessage( e.getMessage() );
				return;
			}
			status.setStatusMessage("Great Success!");
			setChanged();
			notifyObservers();
		}
	}
	
	/**
	 * @param input String to be checked
	 * @return true if no invalid reference is caused by the input, 
	 * 			and if the input is properly formated.
	 */
	private boolean checkInput(String input) {
		try {
			Slot s = sb.build(input);
			s.value();
		} catch (Exception e) {
			System.out.println("Hej");
			System.out.println(e.getMessage());
			if (e instanceof NullPointerException) {
				status.setStatusMessage("Invalid reference!");
				return false;
			} else if (e instanceof XLException) {
				status.setStatusMessage(e.getMessage() );
				return false;
			}
			return false;
		}
		return true;
	}
	
	@Override
	public double value(String name) {
		try {
			return map.get(name).value();
		} catch (NullPointerException e) {
			/*
			 * Name fanns inte i vår map, alltså är den inte initalizerad med ett värde.
			 * Vi kastar ett exception!
			 */
			throw new XLException("Uninitialized reference!");
		}
	}

	@Override
	public void load(File f) throws XLException {
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		if (scan != null) {
			String[] list;
			while (scan.hasNext()) {
				list = scan.nextLine().split("=");
				setValue(list[0], list[1]);
			}
		}
		scan.close();
	}

	@Override
	public void save(File f) throws XLException {
		PrintWriter p = null;
		try {
			p = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
		StringBuilder sb = new StringBuilder();
		for (char c = 'A'; c <= 'Z'; c++) { // A1-Z9 dubbelkolla om detta
											// fungerar
			for (int i = 1; i <= 9; i++) {
				sb.append(c);
				sb.append(i);
				p.println(getValue(sb.toString()));
			}
		}
		p.close();
	}
	
	public boolean clear(String name) throws XLException {
        Slot old = map.remove(name);
        BombSlot bomb = sb.buildBomb();
        map.put(name, bomb);
        try{
        	for( Slot s: map.getList() ){
        		s.value();
            }
        }catch(Exception e){
            map.remove(name);
            map.put(name, old);
            e.getMessage();
            status.setStatusMessage(e.getMessage());
            return false;
        }
        map.remove(name);
        return true;
    }
    
    public void clearAll(){
        map.clear();
    }
}
