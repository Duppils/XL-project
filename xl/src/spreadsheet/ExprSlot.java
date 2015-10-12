package spreadsheet;

import expr.Environment;
import expr.Expr;

public class ExprSlot extends Slot {
	private Expr expr;
	private Environment env;  // VIKTIGT, M�STE DISKUTERA ENVIRONMENT

	public ExprSlot(Expr expr, Environment env) {
		this.expr = expr;
		this.env = env;
	}

	public double value() { 
		return expr.value(env); //Detta �r det �nda s�ttet att returnera h�r
	}

	public double value(String name) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String toString() {
		return expr.toString();
	}
	
}
