package spreadsheet;

public class SlotBuilder implements SlotFactory {
	
	public SlotBuilder(){
		
	}

	@Override
	public Slot build(String name, String input) { //use makeXX()
		return null;
	}
	
	private Slot makeComment(String name, String input) {
		return new CommentSlot(name, input);
	}
	
	private Slot makeExpr(String name, String input) {
		return new ExprSlot(name, input);
	}
	
	private Slot makeBomb(String name, String input) {
		return new BombSlot(name, input);
	}

}
