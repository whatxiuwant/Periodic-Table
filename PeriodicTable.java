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
	
	/*
	public Element getElement(String name) {
		return table[element];
	}
	
	public Element getElement(int atomicNumber) {
		return table[element];
	}
	*/
}