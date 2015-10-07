package controll;

public class Control {
	
	private CurrentModel cm = new CurrentModel();
	private StatusModel sm = new StatusModel();
	
	public Control(){
		
	}
	
	public MouseListener getMouseListener(){
		return new MouseListener();
	}
	public KeyboardListener getKeyBoardListener() {
		return new KeyboardListener();
	}
	
	public CurrentModel getCurrentModel(){
		return cm;
	}
	
	public StatusModel getStatusModel() {
		return sm;
	}
}
