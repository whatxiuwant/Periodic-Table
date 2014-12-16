package ptpkg;

public class CompoundComponent {
	private String symbol;		//C in C6
	private int frequency;		//6 in C6
	
	public CompoundComponent(PeriodicTable table, String name, int frequency) {
		symbol = "" + table.getElement(name);
		this.frequency = frequency;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getFrequency() {
		return frequency;
	}
}
