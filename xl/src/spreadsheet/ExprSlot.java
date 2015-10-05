package spreadsheet;

import expr.Expr;

public class ExprSlot extends Slot{
	private Expr expr;
	
	public ExprSlot(String name, String input){
		super(name, input);
	}

	@Override
	public double value() {
		return 0;
	}

}
