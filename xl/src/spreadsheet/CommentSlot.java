package spreadsheet;

public class CommentSlot extends Slot {
	private String comment;
	
	public CommentSlot(String comment) {
		if ( comment.isEmpty() ) {
			comment = "#";
		}
		this.comment = comment;
	}

	@Override
	public double value() {
		return 0;
	}

	@Override
	public String toString() {
		return comment.substring(1);
	}

	@Override
	public String formattedToString() {
		return comment;
	}

//	@Override
//	public int hashCode() {
//		return 0;
//	}
	
}
