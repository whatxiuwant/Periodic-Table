package ptpkg;
import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.io.*;
import java.util.*;

public class PeriodicTableReader {
	public static void main(String[] args) throws IOException {
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
		System.out.println(table);
		/*
		System.out.println(table.getElement("helium"));
		System.out.println(table.getElement("helium", "name"));
		System.out.println(table.getElement("helium", "atomicnumber"));
		System.out.println(table.getElement("helium", "symbol"));
		System.out.println(table.getElement("helium", "atomicWeight"));
		System.out.println(table.getElement("helium", "mostStableOxidationState"));
		System.out.println(table.getElement("helium", "family"));
		System.out.println(table.getElement("helium", "metal"));
		System.out.println(table.getElement(0).toString());
		
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("SanSerif", Font.PLAIN, 20)));
		UIManager.put("OptionPane.messageForeground", Color.BLACK);
		JOptionPane.showMessageDialog(null, table.getElement(10).toString());
		*/
		scanElement.close();
		
	//	CompoundComponent cc = new CompoundComponent("carbon", 6, table);
	//	Compound compound = new Compound(cc);
	//	System.out.println(cc.toString());
		
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
	//		CompoundComponent cc = new CompoundComponent(compoundStrs.get(j).substring(0, getSymbol(compoundStrs.get(j))), Integer.parseInt(compoundStrs.get(j)), table);
			CompoundComponent cc = new CompoundComponent("Nitrogen", Integer.parseInt(compoundStrs.get(j)), table);
			compound.addCompound(cc);
		}
		for (int j = 0; j < compound.getSize(); j++)
			System.out.println(compound.getCompound(j));
		
		scanCompound.close();
	//	only alphanumerics, no consecutive lowercase
	}

	public static int getSymbol(String s) {
		int idx = 0;
		for (int i = 0; i < s.length(); i++)
			if (s.indexOf(i) >= 0)
				idx++;
		
		return idx;
	}
}