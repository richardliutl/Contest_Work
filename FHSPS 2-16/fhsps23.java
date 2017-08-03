import java.util.*;
import java.io.*;

public class fhsps23 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String[] a = br.readLine().split(" ");
			int[] n = new int[a.length];
			for(int k=0; k<a.length; k++) {
				n[k] = Integer.parseInt(a[k]);
			}
			long v = n[0];
			v *= n[1];
			v *= n[2];
			int s = 0;
			if(v > n[4]) {
				s = (int) Math.floor((v-n[4])/n[3]);
			}
			System.out.printf("%d\n",s);
		}
	}
}