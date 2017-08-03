import java.util.*;
import java.io.*;

public class shapes {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a == 3 || a == 4) {
				System.out.printf("Shape #%d: Johnny's favorite!\n",i+1);
			} else {
				System.out.printf("Shape #%d: Johnny will not be pleased with this one.\n",i+1);
			}
		}
	}
}