import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math; 
import java.util.*; 
import java.util.stream.*; 

public class Bigram {

	public static String[][] bigram(String content, String characterName) throws IOException {


		String[] bg = new String[content.length()];
		int[] bc = new int[content.length()-1];

		for (int i = 0; i < content.length()-1; i++){
			bc[i] = 1;
		}

		for (int i = 0; i<content.length()-1; i++) {
			if(i < content.length()-1){
				bg[i] = content.substring(i,i+2);
			}
		}

		for (int i=0; i<content.length()-1; i++)
		{
			for (int j = i+1; j<content.length(); j++) {
				if (bg[i].equals(bg[j])) {
					bc[i] = bc[i]+1;
				}
			}
		}

		for (int i=0; i<content.length()-1; i++)
		{
			for (int j = i+1; j<content.length(); j++) {
				if (bg[i].equals(bg[j])) {
					bc[j] = bc[i];
				}
			}
		}

		String[][] bf = new String[content.length()-1][2];

		for (int i=0; i<content.length()-1; i++)
		{
			bf[i][0] = bg[i];
			bf[i][1] = Integer.toString(bc[i]);
		}


		for (int i=0; i<content.length()-1; i++)
		{
			for (int j = i+1; j<content.length()-1; j++) {
				if (bf[i][0].equals(bf[j][0]) && bf[i][1].equals(bf[j][1])) {

					bf[j][0]="null";
					bf[j][1]="null";

				}
			}
		}



		int nullCount = 0;
		int total = 0;


		for (int i=0; i<content.length()-1; i++)
		{
			if (bf[i][0].equals("null")){
				nullCount++;
			}
			total++;
		}

		String[][] fin = new String[total-nullCount][2];
		int add = 0;
		for (int i=0; i<content.length()-1; i++)
		{
			if (!bf[i][0].equals("null")){
				fin[add][0] = bf[i][0];
				fin[add][1] = bf[i][1];
				add++;
			}

		}

		PrintWriter outputBigram = new PrintWriter (new FileWriter(characterName + " Bigram.txt"));
		for(int i = 0; i<add; i++) {
			outputBigram.println(fin[i][0] + "," + fin[i][1]);
		}
		
		int totalCount = 0;
		for(int i = 0; i<add; i++) {
			int currentIterations = Integer.parseInt(fin[i][1]);
			totalCount = totalCount + currentIterations;
		}
		
		
		outputBigram.println("TOTAL NUMBER OF BIGRAMS = " + totalCount);
		
		outputBigram.close();
		
		return fin;


	}
}





