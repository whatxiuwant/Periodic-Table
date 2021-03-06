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
			if (table[i].getSymbol().equalsIgnoreCase(name))
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
				if (table[i].getSymbol().equalsIgnoreCase(name))
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
	
	public void sortByName() {
		for (int j = 0; j < table.length - 1; j++) {
			int minIndex = j;
			for (int k = j + 1; k < table.length; k++) 
				if (table[k].getName().compareTo(table[minIndex].getName()) < 0)
					minIndex = k;
			swap(j, minIndex);
		}
	}
	
	public void sortByAtomicWeight(boolean asc) {
		if (asc == true) {
			for (int j = 0; j < table.length - 1; j++) {
				int minIndex = j;
				for (int k = j + 1; k < table.length; k++) 
					if (table[k].getAtomicWeight() < table[minIndex].getAtomicWeight())
						minIndex = k;
				swap(j, minIndex);
		}}
		
		if (asc == false) {
			for (int j = 0; j < table.length - 1; j++) {
				int minIndex = j;
				for (int k = j + 1; k < table.length; k++) 
					if (table[k].getAtomicWeight() > table[minIndex].getAtomicWeight())
						minIndex = k;
				swap(j, minIndex);
		}}
	}
	
	public void sortByAtomicNumber() {
		for (int j = 0; j < table.length - 1; j++) {
			int minIndex = j;
			for (int k = j + 1; k < table.length; k++) 
				if (table[k].getAtomicNumber() < table[minIndex].getAtomicNumber())
					minIndex = k;
			swap(j, minIndex);
		}
	}
	
	public void sortBySymbol() {
		for (int j = 0; j < table.length - 1; j++) {
			int minIndex = j;
			for (int k = j + 1; k < table.length; k++) 
				if (table[k].getSymbol().compareTo(table[minIndex].getSymbol()) < 0)
					minIndex = k;
			swap(j, minIndex);
		}
	}
	
	public void swap(int j, int k) {
		Element temp = table[j];
		table[j] = table[k];
		table[k] = temp;
	}
	
	public String toString() {
		String display = "";
		for (int i = 0; i < table.length; i++)
			display += "\n" + table[i];
		
		return display;
	}
}
