package spreadsheet;

public class CommentSlot extends Slot {
	private String input;

	public CommentSlot(String input) {
		this.input = input.substring(1);
	}

	@Override
	public double value() {
		return 0;
	}
}
