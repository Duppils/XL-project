package controll;

public class Control {
	public MouseListener getMouseListener(){
		return new MouseListener();
	}
	public KeyboardListener getKeyBoardListener() {
		return new KeyboardListener();
	}
}
