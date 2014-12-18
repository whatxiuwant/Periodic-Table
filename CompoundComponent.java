package ptpkg;

public class CompoundComponent {
	private String symbol;		//C in C6
	private int frequency;		//6 in C6
	private PeriodicTable pt;
	
	public CompoundComponent(String name, int frequency, PeriodicTable pt) {
		symbol = "" + pt.getElement(name, "symbol");
		this.frequency = frequency;
		this.pt = pt;
		
		//change name to symbol
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public int getFrequency() {
		return frequency;
	}

	public PeriodicTable getPt() {
		return pt;
	}
	
	public String toString() {
		return symbol + frequency;
	}
	
	public double weight() {
		Element e = pt.getElement("symbol");
		return e.getAtomicWeight() * frequency;
	}
}