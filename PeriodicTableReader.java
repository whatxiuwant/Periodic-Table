package ptpkg;
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
		
		scanElement.close();
		table.sortByName();
		System.out.println(table);
		table.sortByAtomicWeight(true);
		System.out.println(table);
		table.sortByAtomicWeight(false);
		System.out.println(table);
		table.sortByAtomicNumber();
		System.out.println(table);
		table.sortBySymbol();
		System.out.println(table);
	}
}
