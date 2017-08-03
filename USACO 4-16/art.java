import java.io.*;

public class art {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("art.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("art.out"));
		int n = Integer.parseInt(br.readLine()); //canvas size
		int[][] c = new int[n][n]; //stores painting
		int[][] b = new int[n*n+1][5]; //stores bounds, given by c[b[0]:b[1]][b[2]:b[3]]
			//also stores intactity b[][4]
		boolean[][] d = new boolean[n*n+1][n*n+1]; //stores dependencies
			//d[i][j] if rectangle by color i is overlapped BY color j, described as dependent
		int[] p = new int[n*n+1];
		int r = 0;
		for(int i=0; i<n*n+1; i++) {
			b[i][0] = -1;
		}
		for(int i=0; i<n; i++) {
			String[] a = br.readLine().split(" ");
			for(int j=0; j<n; j++) { //instantiates b[] array of bounds
				c[i][j] = Integer.parseInt(a[j]);
				if(b[c[i][j]][0] == -1) {
					b[c[i][j]][0] = i;
					b[c[i][j]][1] = i;
					b[c[i][j]][2] = j;
					b[c[i][j]][3] = j;
				}
				if(i < b[c[i][j]][0]) {
					b[c[i][j]][0] = i;
				}
				if(i > b[c[i][j]][1]) {
					b[c[i][j]][1] = i;
				}
				if(j < b[c[i][j]][2]) {
					b[c[i][j]][2] = j;
				}
				if(j > b[c[i][j]][3]) {
					b[c[i][j]][3] = j;
				}
			} //instantiated
		} //end input

		//now find dependencies, ~O(n^3)
		for(int k=0; k<n*n+1; k++) { //iterate through color k
			if(b[k][0] >= 0) {
				boolean intact = true;
				for(int i=b[k][0]; i<=b[k][1]; i++) { //iterate through bounds
					for(int j=b[k][2]; j<=b[k][3]; j++) {
						if(c[i][j] != k) {
							d[k][c[i][j]] = true;
							intact = false;
						}
					}
				}
				if(intact) b[k][4] = 1;
			}
		}

		//dp through
		for(int k=1; k<n*n+1; k++) {
			r = Math.max(r,dp(n,b,d,p,k));
		}
		/*
		for(int i=1; i<n*n+1; i++) {
			System.out.println("DP["+i+"] = "+p[i]);
		}
		for(int i=0; i<n*n+1; i++) {
			for(int j=0; j<5; j++) {
				System.out.print(b[i][j]+" ");
			}
			System.out.print("\n"+(i+1)+": ");
		}
		*/
		bw.write(r+"\n");
		br.close();
		bw.close();
	}
	public static int dp(int n, int[][] b, boolean[][] d, int[] p, int k) {
		int r = 0;
		if(p[k] > 0) return p[k];
		if(b[k][4] == 1) { //if intact
			p[k] = 1;
			return 1;
		}
		for(int i=1; i<n*n+1; i++) {
			if(d[k][i]) r = Math.max(r, dp(n,b,d,p,i) + 1);
		}
		p[k] = r;
		return r;
	}
}
/*
4
2 2 3 0
2 7 3 7
2 7 7 7
0 5 5 5

*/