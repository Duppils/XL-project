package spreadsheet;

import expr.Environment;
import expr.Expr;

public class ExprSlot extends Slot implements Environment {
	private Expr expr;
	private Environment env;  // VIKTIGT, M�STE DISKUTERA ENVIRONMENT

	public ExprSlot(Expr expr) {
		this.expr = expr;
	}

	@Override
	public double value() { 
		return expr.value(env); //Detta �r det �nda s�ttet att returnera h�r
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
