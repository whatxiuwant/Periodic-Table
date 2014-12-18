package ptpkg;

public class PeriodicTable {
	private Element[] table;
	private int length;
	
	public PeriodicTable(int length) {
		table = new Element[length];
		this.length = length;
	}
	
	public void push(int idx, Element e) {
		table[idx] = e;
	}
	
	public int getLength() {
		return length;
	}
	
	public Element getElement(int idx) {
		return table[idx];
	}


	public Element getElement(String name) {
		for (int i = 0; i < length; i++)
			if (table[i].getName().equalsIgnoreCase(name))
				return table[i];
		
		return table[-999];
	}
	
	public String getElement(String name, String value) {
		if (value.equalsIgnoreCase("name"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					return table[i].getName();
		
		//for (Element e : table)
		//	if (e.getSymbol().equals(symbol))
		//		return e;
		//	return null;
		
		if (value.equalsIgnoreCase("atomicNumber"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					return "" + table[i].getAtomicNumber();
		
		if (value.equalsIgnoreCase("symbol"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					return table[i].getSymbol();
		
		if (value.equalsIgnoreCase("atomicWeight"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					return "" + table[i].getAtomicWeight();
		
		if (value.equalsIgnoreCase("mostStableOxidationState") || value.equalsIgnoreCase("msos"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					return "" + table[i].getMSOS();
		
		if (value.equalsIgnoreCase("family"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					return table[i].getFamily();
		
		if (value.equalsIgnoreCase("metal"))
			for (int i = 0; i < length; i++)
				if (table[i].getName().equalsIgnoreCase(name))
					if (table[i].getMetal() == true)
						return "metal";
					else
						return "nonmetal";
		
		return "not found";
	}
	
	public String toString() {
		String display = "";
		for (int i = 0; i < table.length; i++)
			display += "\n" + table[i];
		
		return display;
	}
}