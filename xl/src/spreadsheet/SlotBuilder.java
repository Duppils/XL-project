package spreadsheet;

import java.io.IOException;
import expr.Expr;
import expr.ExprParser;

public class SlotBuilder implements SlotFactory {
	private ExprParser parser;
	
	public SlotBuilder(){
		parser = new ExprParser();
	}

	@Override
	public Slot build(String input) {
		if(input.startsWith("#")){
			return new CommentSlot(input);
		}else if(input == ""){   //kan ändras beroende på hur BombSlot används
			return new BombSlot();
		}
		Expr temp = null;
		try{
			temp = parser.build(input);
		}catch(IOException e){
			System.err.println(e.getMessage());
		}	
		return new ExprSlot(temp);
	}
	
}
