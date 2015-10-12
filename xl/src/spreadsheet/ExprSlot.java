package spreadsheet;

import expr.Environment;
import expr.Expr;

public class ExprSlot extends Slot {
	private Expr expr;
	private Environment env; 

	public ExprSlot(Expr expr, Environment env) {
		this.expr = expr;
		this.env = env;
	}

	public double value() { 
		return expr.value(env); 
	}

	
	@Override
	public String toString() {
		return new Double( expr.value(env) ).toString() ;
	}

	@Override
	public String formattedToString() {
		return expr.toString();
	}

//	@Override
//	public int hashCode() {
//		return 0;
//	}
	
}
