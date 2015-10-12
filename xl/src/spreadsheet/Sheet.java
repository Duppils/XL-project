package spreadsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import util.XLException;
import gui.SheetBase;

public class Sheet extends SheetBase {
	private HashMap<String, Slot> map;
	private SlotBuilder sb;
	
	public Sheet(){
		sb = new SlotBuilder(this);
		map = new HashMap<String, Slot>();
	}

	public String getValue(String name) throws XLException{ 
		return map.get(name).toString();
	}
	
	public void setValue(String name, String input) throws XLException{
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
	public double value(String name){ 
		try{
			return map.get(name).value();
		}catch(NullPointerException e){
			System.err.println(e.getMessage());
		}
		return 0;
	}
	
	@Override
	public void load(File f) throws XLException{
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());  
		}
		if(scan != null){
			String[] list;
			while(scan.hasNext()){
				list = scan.nextLine().split("=");
				setValue(list[0], list[1]);
			}
		}
		scan.close();
	}
	
	@Override
	public void save(File f) throws XLException{
		PrintWriter p = null;
		try{
			p = new PrintWriter(f);
		}catch(FileNotFoundException e){
			System.err.println(e.getMessage());
		}
		StringBuilder sb = new StringBuilder();
		for(char c = 'A'; c <= 'Z'; c++){  // A1-Z9 dubbelkolla om detta fungerar
			for(int i = 1; i <= 9; i++){
				sb.append(c + i);
				p.println(getValue(sb.toString()));
			}
		}
		p.close();
	}

}
