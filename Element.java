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
		String metalString = "";
		if (atomicNumber < 100)
			element += getSpaces(1) + atomicNumber;
		else if (atomicNumber < 10)
			element += getSpaces(2) + atomicNumber;
		else
			element += atomicNumber;
		
		if (metal == true)
			metalString = "M";
		else
			metalString = "N";
		
		element += getSpaces(5) + name;
		element += getSpaces(20 - name.length()) + symbol;
		element += getSpaces(10 - symbol.length()) + atomicWeight;
		element += getSpaces(15 - ("" + atomicWeight).length()) + mSOS;
		element += getSpaces(10 - ("" + mSOS).length()) + family;
		element += getSpaces(30 - family.length()) + metalString;
		
		return element;
	}
	
	public String getSpaces(int length) {
		String spaces = "";
		for (int i = 0; i < length; i++)
			spaces += " ";
		
		return spaces;
	}
}