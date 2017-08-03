import java.io.*;
import java.util.*;
public class Prob06{
    private static final String INPUT_FILE_NAME = "Prob06.in.txt";
	public static void main(String[] args) throws IOException{
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
		String[] nato = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India", "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango", "Uniform", "Victor", "Whiskey", "Xray", "Yankee", "Zulu"};
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i<n; i++){
			int m = Integer.parseInt(br.readLine());
			for(int j = 0; j<m; j++){
				char[] phrase = br.readLine().toCharArray();

				for(int d = 0; d<phrase.length; d++){
					if(phrase[d]>=97) {
						phrase[d] -= 32;
					}
					//System.out.println(phrase[d]);
					if(d!=0 && phrase[d]!=' ' && phrase[d-1]!=' ')
						System.out.print('-');
					if(phrase[d]==' ')
						System.out.print(' ');
					else {
						System.out.print(nato[phrase[d] - 'A']);
					}
				}

				System.out.println();
			}
		}
	}
}