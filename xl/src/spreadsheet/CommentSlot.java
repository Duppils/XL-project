package spreadsheet;

public class CommentSlot extends Slot {
	private String value;

	public CommentSlot(String name, String input) {
		super(name, input);
		value = input;
	}

	@Override
	public double value() {
		// TODO Auto-generated method stub
		return 0;
	}

}
