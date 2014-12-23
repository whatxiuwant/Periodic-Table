package ptpkg;
import java.util.*;

public class Compound {
	private ArrayList<CompoundComponent> compound;
	
	public Compound() {
		compound = new ArrayList<CompoundComponent>();
	}
	
	public int getSize() {
		return compound.size();
	}
	
	public CompoundComponent getCompound(int idx) {
		return compound.get(idx);
	}
	
	public String toString() {
		String display = "";
		for (int i = 0; i < compound.size(); i++)
			display += compound.get(i).getSymbol() + compound.get(i).getFrequency();
		
		return display;
	}
	
	public ArrayList<CompoundComponent> getCompound() {
		return compound;
	}
	
	public void addCompound(CompoundComponent c) {
		compound.add(c);
	}
	
	public double getMolecularWeight() {
		double weight = 0;
		for (CompoundComponent cc : compound)
			weight += cc.weight(cc.getSymbol());
		
		return weight;
	}
}