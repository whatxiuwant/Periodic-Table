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
}
