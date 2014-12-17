package ptpkg;
import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.io.*;
import java.util.*;

public class PeriodicTableReader {
	public static void main(String[] args) throws IOException {
		File input = new File("Elements.csv");
		Scanner scan = new Scanner(input);
		
		int count = 0;
		while (scan.hasNextLine()) {
			scan.nextLine();
			count++;
		}
		
		scan.close();
		
		Scanner scan2 = new Scanner(input);
		
		PeriodicTable table = new PeriodicTable(count);
		int i = 0;
		String[] elementData = new String[7];
		String n, s, f; int aN, mSOS; double aW; boolean m;
		
		while (scan2.hasNextLine()) {
			elementData = scan2.nextLine().split(",");
			
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
		
		scan2.close();
		
		CompoundComponent cc = new CompoundComponent(table, carbon, 6);
		Compound compound = new Compound(cc);
		System.out.println(cc.toString());
	}
}
