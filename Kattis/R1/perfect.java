import java.util.*;
import java.io.*;

public class perfect {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String[] a = br.readLine().split(" ");
			int[] n = new int[a.length];
			int s = 0;
			String oo = "";
			for(int k=0; k<a.length; k++) {
				n[k] = Integer.parseInt(a[k]);
			}
			for(int x=n[2]; x<=n[3]; x++) {
				if((n[0] - x*n[1]) > 0 && (n[0] - x*n[1]) % (x + 1) == 0) {
					s++;
					oo += String.format("%d %d\n",x,(n[0] - x*n[1])/(x + 1));
				}
			}
			System.out.printf("Wall #%d: %d\n",(i+1),s);
			System.out.printf(oo+"\n");
		}
	}
}