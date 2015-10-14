package spreadsheet;
/** CommentSlot is a type of Slot that contains a comment.
*
* It contains a # followed by a String.
*/
public class CommentSlot extends Slot {
	private String comment;
	
	public CommentSlot(String comment) {
		if ( comment.isEmpty() ) {
			comment = "#";
		}
		this.comment = comment;
	}
	/**
	* @return the value that corresponds to a CommentSlot, which is always 0.
	*/
	@Override
	public double value() {
		return 0;
	}
	/**
	* @return a String for use in representation of slots in GUI
	*/
	@Override
	public String toString() {
		return comment.substring(1);
	}
	/**
	* @return a formatted String for use in expression editor
	*/
	@Override
	public String formattedToString() {
		return comment;
	}

//	@Override
//	public int hashCode() {
//		return 0;
//	}
	
}
