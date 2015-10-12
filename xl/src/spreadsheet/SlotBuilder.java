package spreadsheet;

import java.io.IOException;

import util.XLException;
import expr.Expr;
import expr.ExprParser;
import expr.Environment;

public class SlotBuilder implements SlotFactory {
	private ExprParser parser;
	private Environment env;
	
	public SlotBuilder(Environment env){
		parser = new ExprParser();
		this.env = env;
	}

	@Override
	public Slot build(String input) throws XLException{
		if ( input.isEmpty() ) {
			return new CommentSlot("");
		}
		if( input.startsWith("#") ){
			return new CommentSlot(input);
		}
		Expr temp = null;
		try{
			temp = parser.build(input);
		} catch(IOException e){
			System.err.println(e.getMessage());
		}
		return new ExprSlot(temp, env);
	}

	@Override
	public BombSlot buildBomb() {
		// TODO Auto-generated method stub
		return new BombSlot();
	}
	
}
