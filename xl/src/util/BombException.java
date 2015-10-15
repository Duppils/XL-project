package util;

public class BombException extends XLException {
	BombException(String msg) {
		super(msg);
	}
	BombException(){
		super("Circular dependency detected.");
	}
}
