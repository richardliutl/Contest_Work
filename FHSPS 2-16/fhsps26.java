import java.util.*;
import java.io.*;

public class fhsps26 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			int tt = Integer.parseInt(br.readLine());
			int[][] ss = new int[tt+1][tt+1];
			for(int x=0; x<tt+1; x++) {
				for(int y=0; y<tt+1; y++) {
					ss[x][y] = -1;
				}
			}
			for(int t=0; t<tt; t++) {
				String[] a = br.readLine().split(" ");
				ss[t+1][Integer.parseInt(a[1])] = Integer.parseInt(a[0]);
			}

			System.out.printf("%d\n",flow(ss,0));
		}
	}
	public static int flow(int[][] ss, int s) {
		int f = base(ss, s);
		int small = 0;
		boolean bad = true;
		for(int i=1; i<ss.length; i++) {
			if(ss[i][s] >= 0) {
				bad = false;
				small += flow(ss, i);
			}
		}
		if(bad || small > f) return f;
		return small;
	}
	public static int base(int[][] ss, int s) {
		if(s == 0) return Integer.MAX_VALUE;
		for(int i=0; i<ss.length; i++) {
			if(ss[s][i] >= 0) {
				return ss[s][i];
			}
		}
		return -1;
	}
}