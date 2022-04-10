import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Cleaning {

	public static String clean (String filename) throws FileNotFoundException {
		
		Scanner scanner = new Scanner( new File(filename) );
		String text = scanner.useDelimiter("\\A").next();
		scanner.close(); // Put this call in a finally block
		String cs1 = text.replaceAll("\r", "---").replaceAll("\n", "12345");
		String csa = cs1.replaceAll("---", "    ");
		String csb = csa.replaceAll("12345", "    ");
		String cs2 = csb.replaceAll("           ", " ");
		String cs3 = cs2.replaceAll("          ", " ");
		String cs4 = cs3.replaceAll("         ", " ");
		String cs5 = cs4.replaceAll("        ", " ");
		String cs6 = cs5.replaceAll("       ", " ");
		String cs7 = cs6.replaceAll("      ", " ");
		String cs8 = cs7.replaceAll("     ", " ");
		String cs9 = cs8.replaceAll("    ", " ");
		String csf = cs9.replaceAll("  ", " ");
		
		return csf;
	}
}
