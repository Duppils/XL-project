package spreadsheet;

public class SlotBuilder implements SlotFactory {
	
	public SlotBuilder(){
		
	}

	@Override
	public Slot build(String input) {
		if(input.startsWith("#")){
			return new CommentSlot(input);
		}
		return new ExprSlot(input);
	}
	
	public BombSlot buildBomb(){
		return new BombSlot();
	}

}
