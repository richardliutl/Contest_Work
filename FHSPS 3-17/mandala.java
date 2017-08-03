import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class mandala {
	public static void main(String args[]) throws IOException {
		int[] man = new int[]{0,5,10,20,30,40};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int n0=0; n0<n; n0++) {
			String[] a = br.readLine().split(" ");
			int c = Integer.parseInt(a[0]);
			int r = Integer.parseInt(a[1]);
			int t = Integer.parseInt(a[2]);
			int m = 0;
			boolean[][] g = new boolean[c+1][c+1];
			for(int r0=0; r0<r; r0++) {
				a = br.readLine().split(" ");
				int k0 = Integer.parseInt(a[0]);
				int k1 = Integer.parseInt(a[1]);
				g[k0][k1] = true;
				g[k1][k0] = true;
			}
			for(int t0=0; t0<t; t0++) {
				a = br.readLine().split(" ");
				int k0 = Integer.parseInt(a[0]);
				int k1 = Integer.parseInt(a[1]);
				int k = 0;
				boolean[][] g0 = new boolean[c+1][c+1];
				for(int i=1; i<c+1; i++) {
					for(int j=1; j<c+1; j++) {
						g0[i][j] = g[i][j];
					}
				}
				ArrayList<Integer> arr = new ArrayList<Integer>();
				for(int i=1; i<c+1; i++) {
					if(g0[k0][i]) {
						g0[k0][i] = false;
						g0[i][k0] = false;
						if(i == k1) k++;
						else arr.add(i);
					}
				}
				while(!arr.isEmpty() && k < 2) {
					int k9 = arr.remove(0);
					for(int i=1; i<c+1; i++) {
						if(g0[k9][i]) {
							arr.add(i);
							g0[k9][i] = false;
							g0[i][k9] = false;
							if(i == k1) k++;
							else arr.add(i);
						}
					}
				}
				if(k >= 2) m++;
			}
			if(m >= 0 && m < 6)	System.out.println(man[m]);
			else System.out.println(40);
		}
	}
}
/*
2
3 3 2
1 3
3 2
2 1
1 3
2 3
4 4 3
1 2
2 3
3 1
1 4
1 4
1 3
4 2

*/