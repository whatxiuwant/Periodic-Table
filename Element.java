package ptpkg;

public class Element {
	private String name, symbol, family;
	private int atomicNumber, mSOS;		//mSOS = most stable oxidation state
	private double atomicWeight;
	private boolean metal;
	
	public Element(String n, int aN, String s, double aW, int mSOS, String f, boolean m) {
		name = n;
		atomicNumber = aN;
		symbol = s;
		atomicWeight = aW;
		this.mSOS = mSOS;
		family = f;
		metal = m;
	}
	
	public String getName() {
		return name;
	}
	public int getAtomicNumber() {
		return atomicNumber;
	}
	
	public String getSymbol() {
		return symbol;
	}
	
	public double getAtomicWeight() {
		return atomicWeight;
	}
	
	public int getMSOS() {
		return mSOS;
	}
	
	public String getFamily() {
		return family;
	}
	
	public boolean getMetal() {
		return metal;
	}
	
	public String toString() {
		String element = "";
		element += "Name: " + name + ",\nAtomic Number: " + atomicNumber + ",\nSymbol: " + symbol + ",\nAtomic Weight: " + atomicWeight + ",\nMost Stable Oxidation State: " + mSOS + ",\nFamily: " + family + ",\nMetal: ";
		if (metal == true)
			element += "metal";
		else
			element += "nonmetal";
		
		return element;
	}
}