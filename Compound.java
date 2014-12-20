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
	
	public String getCompound(int idx) {
		return compound.get(idx).getSymbol() + compound.get(idx).getFrequency();
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
			weight += cc.weight();
		
		return weight;
	}
}
