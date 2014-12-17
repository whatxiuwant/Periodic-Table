package ptpkg;
import java.util.*;

public class Compound {
	private ArrayList<CompoundComponent> compound;
	
	public void addCompound(CompoundComponent c) {
		compound.add(c);
	}
	
	public ArrayList<CompoundComponent> getCompoundComponent() {
		return compound;
	}
}
