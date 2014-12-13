package ptpkg;
import java.util.*;
import java.io.*;

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
	//	Element[] table = new Element[count];
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
		
		scan2.close();
	}
}