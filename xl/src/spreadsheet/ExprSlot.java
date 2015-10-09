package spreadsheet;

import java.io.IOException;

import expr.Expr;
import expr.ExprParser;

public class ExprSlot extends Slot {
	private Expr expr;

	public ExprSlot(String input) {
		expr = build(input); 
	}

	@Override
	public double value() { //kanske en expr.op(parser.temr(), parser.factor()) 
		return 0;
	}
	
	private Expr build(String input){  
		Expr temp = null;
		try{
			ExprParser parser = new ExprParser();
			temp = parser.build(input);
		}catch(IOException e){
			System.err.println(e.getMessage());
		}		
		
		return temp;
	}

}
