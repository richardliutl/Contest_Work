import java.util.*;
import java.io.*;

public class fhsps22 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			int s = (int) Math.pow(2,Math.floor((Integer.parseInt(br.readLine())-1)/5.0));
			System.out.printf("%d\n",s);
		}
	}
}