package spreadsheet;

public class CommentSlot extends Slot {
	private String comment;

	public CommentSlot(String comment) {
		this.comment = comment.substring(1);
	}

	@Override
	public double value() {
		return 0;
	}

	@Override
	public String toString() {
		return comment;
	}
	
	
}
