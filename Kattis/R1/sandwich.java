import java.util.*;
import java.io.*;

public class sandwich {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String a = br.readLine();
			long n = Long.parseLong(a);
			long s = 0;
			if(a.length() > 1) {
				s = Math.pow(10,a.length()-1)-1;
			}
			if(a.length() > 1) {
				if(a.length()%2 == 0) {
					String a1 = a.substring(0,a.length()/2);
					String a2 = a.substring(a.length()/2,a.length());
					
				} else {

				}
			}
			System.out.printf("Row #%d: Jerry needs to add a minimum of %d coins\n",(i+1),s);
		}
	}
}