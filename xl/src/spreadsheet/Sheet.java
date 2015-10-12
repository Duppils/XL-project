package spreadsheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Observable;
import java.util.Scanner;

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
	
	public void loadFromFile(File f){
		Scanner scan = null;
		try {
			scan = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());  //vilken metod �r b�st h�r?
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
	
	public void savetoFile(File f){
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
