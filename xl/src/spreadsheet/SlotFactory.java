package spreadsheet;

public interface SlotFactory {
	public Slot build(String input);
	public BombSlot buildBomb();
}
