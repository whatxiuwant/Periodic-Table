package ptpkg;
import java.util.*;
import java.io.*;

public class PeriodicTableReader {
	public static void main(String[] args) throws IOException {
		File input = new File("Elements.csv");
		Scanner scan = new Scanner(input);
		
		int count = 0;
		while(scan.hasNextLine()) {
			scan.nextLine();
			count++;
		}
		
		PeriodicTable[] table = new PeriodicTable[count - 1];
		
		String element = "";
		while(scan.hasNextLine()) {
			element = scan.nextLine();
			System.out.println(element);
		}
		
		for (int i = 0; i < table.length; i++)
	//		table[i] = new Element();
			
		scan.close();
	}
}