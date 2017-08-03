import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class art2T {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] a = new int[n]; //stores painting with color at i, at index i
		int[] b = new int[n]; //stores most recent index of color i, at index i
		int r = 0;
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(br.readLine());
			if(a[i] >= 0) {
				if(b[a[i]] == i-1 || b[a[i]] == 0) {
					b[a[i]] = i + 1;
				} else if(b[a[i]] > 0) {
					r = Math.max(r, 1 + dp(a,b,b[a[i]],i-1,a[i])); //DP on array b, index b[a[i]]:i, base a[i]
				} else if(b[a[i]] < 0) {
					r = -1;
					break;
				}
			}
		}
		System.out.println(r);
	}
	public static int dp(int[] a, int[] b, int j, int k, int base) {
		int r = 1;
		for(int i=j; i<=k; i++) {
			if(b[a[i]] == i) {
				b[a[i]] = -1;
			} else if(b[a[i]] == i + 1) {
				b[a[i]] = -1;
				i = i + 1;
			} else if(b[a[i]] > 0) {
				r = Math.max(r, 1 + dp(a,b,i+1,b[a[i]]-1,a[i]));
			}
		}
		return r;
	}
}
/*
7
0
1
4
5
1
3
3

*/
/*
9
1
2
3
4
5
4
3
2
1

*/