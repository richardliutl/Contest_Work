import java.util.*;
import java.io.*;

public class squircle {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String[] a = br.readLine().split(" ");
			int[] aa = new int[a.length];
			int s = 0;
			for(int k=0; k<a.length; k++) {
				aa[k] = Integer.parseInt(a[k]);
			}
			for(int n=0; n<aa[0]*1.0/aa[1] - 0.5; n++) {
				double x = (2.0*n + 1.0)*aa[1]/2.0;
				double y = aa[0]*aa[0] - x*x;
				if(y > 0) {
					y = Math.sqrt(y);
					s += Math.floor(2.0*y/aa[1]);
					if(n > 0) {
						s += Math.floor(2.0*y/aa[1]);
					}
				}
			}
			System.out.printf("Measure #%d: %d\n",(i+1),s*aa[1]*aa[1]);
		}
	}
}