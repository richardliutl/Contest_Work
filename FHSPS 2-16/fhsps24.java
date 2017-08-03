import java.util.*;
import java.io.*;

public class fhsps24 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String a = br.readLine();
			int[] o = new int[8];
			for(int k=0; k<a.length(); k++) {
				String bb = Integer.toBinaryString(a.charAt(k));
				o[bb.length()-bb.replace("1","").length()]++;
			}
			String s = "You are safe";
			for(int k=0; k<8; k++) {
				if(o[k] > 3) {
					s = "He is going to get 'em";
					break;
				}
			}
			System.out.printf("%s\n",s);
		}
	}
}