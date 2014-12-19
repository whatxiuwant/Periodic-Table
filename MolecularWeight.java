package ptpkg;
import java.io.*;
import java.util.*;

public class MolecularWeight {
	public static void main(String[] args) throws IOException {
		Scanner scanCompound = new Scanner(System.in);
		System.out.println("Enter the chemical compound formula: ");
		String compText = scanCompound.nextLine();
	//	make method
		ArrayList<Integer> idx = new ArrayList<Integer>();
		
		for (int j = 0; j < compText.length(); j++)
			if (compText.charAt(j) >= 'A' && compText.charAt(j) <= 'Z')
				idx.add(j);

		ArrayList<String> compoundStrs = new ArrayList<String>();
		int end = 0;
		for (int j = 0; j < idx.size(); j++) {
			if (j == idx.size() - 1)
				end = compText.length();
			else
				end = idx.get(j + 1);

			compoundStrs.add(compText.substring(idx.get(j), end));
		}
		
		System.out.println(compoundStrs);
		
		Compound compound = new Compound();
		
		for (int j = 0; j < compoundStrs.size(); j++) {
			CompoundComponent cc = new CompoundComponent(compoundStrs.get(j).substring(0, getFreq(compoundStrs.get(j))), Integer.parseInt(compoundStrs.get(j).substring(getFreq(compoundStrs.get(j)))), getTable());
			compound.addCompound(cc);
		}
		
		for (int i = 0; i < compound.getSize(); i++)
			System.out.println(compound.getCompound(i));
		
		System.out.println(compound.getCompound(0).weight());
		
		scanCompound.close();
	}
	
	public static PeriodicTable getTable() throws IOException {
		File input = new File("Elements.csv");
		Scanner scanCount = new Scanner(input);
		
		int count = 0;
		while (scanCount.hasNextLine()) {
			scanCount.nextLine();
			count++;
		}
		
		scanCount.close();
		
		Scanner scanElement = new Scanner(input);
		
		PeriodicTable table = new PeriodicTable(count);
		int i = 0;
		String[] elementData = new String[7];
		String n, s, f; int aN, mSOS; double aW; boolean m;
		
		while (scanElement.hasNextLine()) {
			elementData = scanElement.nextLine().split(",");
			
			n = elementData[0];
			aN = Integer.parseInt(elementData[1]);
			s = elementData[2];
			aW = Double.parseDouble(elementData[3]);
			if (elementData[4].equals(""))
				mSOS = -999;
			else
				mSOS = Integer.parseInt(elementData[4]);
			f = elementData[5];
			if (elementData[6].equals("M"))
				m = true;
			else
				m = false;
			
			Element e = new Element(n, aN, s, aW, mSOS, f, m);
			table.push(i, e);
			i++;
		}
		
		scanElement.close();
		return table;
	}
	
	public static int getFreq(String s) {
		int idx = 0;
		for (int i = s.length() - 1; i >= 0; i--)
			if (isDigit(s.charAt(i)))
				idx++;
	
		return idx; 
	}
	
	public static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}
}
