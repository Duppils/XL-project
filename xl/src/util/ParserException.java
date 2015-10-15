package util;

public class ParserException extends XLException {

	public ParserException(String message) {
		super(message);
	}
	
	public ParserException(){
		super("Invalid input format!");
	}
}
