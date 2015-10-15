package spreadsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import util.ParserException;
import util.XLException;
import gui.SheetBase;

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
		Slot newSlot;
		// om cellen är tom, ta bort den.
		if ( input.isEmpty()) {
			clear(name);
			return;
		}
		// kolla om input är rätt formatterat, eller om det är referenser som blir fel
		try {
			newSlot = checkInput(input);
		} catch (XLException e) {
			return;
		}
		// pröva sätta in den nya sloten.
		Slot oldSlot = map.get(name);
		try {
			map.put(name, sb.buildBomb());
			newSlot.value(); //kollar efter cirkulära dependencies
			map.put(name, newSlot);
			
			//nu ska vi kolla efter division med noll för alla andra slots. 
			LinkedList<String> list = map.getList();
			for (int i = 0; i < list.size() ; i++ ) {
				map.get( list.get(i) ).value();
			}
		} catch (Exception e) {
			//någonting blev fel, återställ.
			if (oldSlot != null) {
				map.put(name, oldSlot);
			}
			status.setStatusMessage(e.getMessage());
			return;
		}
		status.setStatusMessage("Great Success!");
		setChanged();
		notifyObservers();
	}
	
	/**
	 * @param input String to be checked
	 * @return a new SlotObject if no invalid reference is caused by the input, 
	 * 			and if the input is properly formated.
	 * Updates the status-object if it throws an exception.
	 */
	private Slot checkInput(String input) throws XLException {
		try {
			Slot s = sb.build(input);
			s.value();
			return s;
		} catch (Exception e) {
			if (e instanceof NullPointerException) {
				status.setStatusMessage("Invalid reference!");	
			} else if (e instanceof XLException) {
				status.setStatusMessage(e.getMessage() );
			} else { 
				status.setStatusMessage("Improperly formatted input.");
			}
			throw new ParserException();
		}
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
			//System.err.println(e.getMessage());
			status.setStatusMessage("Error in reading from file!");
		}
		if (scan != null) {
			String[] list;
			while (scan.hasNext()) {
				list = scan.nextLine().split("=",2);
				setValue(list[0], list[1]);
			}
		}
		scan.close();
		status.setStatusMessage("Great success in loading from file!");
		setChanged();
		notifyObservers();
	}

	@Override
	public void save(File f) throws XLException {
		PrintWriter p = null;
		try {
			p = new PrintWriter(f);
		} catch (FileNotFoundException e) {
			//System.err.println(e.getMessage());
			status.setStatusMessage("I can't let you save to file, Dave...");
		}
		StringBuilder sb = new StringBuilder();
		LinkedList<String> slotID = map.getList();
		
		for (String ID: slotID) {
			Slot slot = map.get(ID);
			sb.append(ID);
			sb.append("=");
			sb.append(slot.formattedToString() );
			sb.append("\n");
		}
		p.append(sb);
		p.close();
		status.setStatusMessage("Saved succesfully.");
	}
	
	public boolean clear(String name) throws XLException {
        Slot old = map.remove(name);
        try{
        	/*
        	 * Kolla så att inga andra slots beror på den vi försöker ta bort.
        	 */
        	for( String s: map.getList() ){
        		map.get(s).value();
            }
        }catch(Exception e){
        	// någonting berodde på den. Lägg tillbaka.
            map.put(name, old);
            e.getMessage();
            status.setStatusMessage("Error: something depends on this cell!");
            return false;
        }
        setChanged();
        notifyObservers();
        return true;
    }
    
    public void clearAll(){
        map.clear();
        setChanged();
        notifyObservers();
    }
}
