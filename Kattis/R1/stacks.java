import java.util.*;
import java.io.*;

public class stacks {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			int aa = Integer.parseInt(br.readLine());
			String[] a = br.readLine().split(" ");
			int s1 = 0; int s2 = 0; int s = 0;
			for(int k=0; k<aa; k++) {
				int p = Integer.parseInt(a[k])%2;
				if(p == k%2) {
					s1++;
				} else {
					s2++;
				}
			}
			s = s1;
			if(s1 > s2) {
				s = s2;
			}
			System.out.printf("Row #%d: Jerry needs to add a minimum of %d coins\n",(i+1),s);
		}
	}
}