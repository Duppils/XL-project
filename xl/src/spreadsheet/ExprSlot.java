package spreadsheet;

import expr.Environment;
import expr.Expr;

public class ExprSlot extends Slot implements Environment {
	private Expr expr;
	private Environment env;  // VIKTIGT, MÅSTE DISKUTERA ENVIRONMENT

	public ExprSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public double value() { 
		return expr.value(env); //Detta är det ända sättet att returnera här
	}

	@Override
	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return expr.toString();
	}
	

}
