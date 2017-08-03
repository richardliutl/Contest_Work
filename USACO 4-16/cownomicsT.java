import java.io.*;

public class cownomicsT {
	public static void main(String args[]) throws IOException {
		String genes = "ACGT";

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int n = Integer.parseInt(arr[0]);
		int m = Integer.parseInt(arr[1]);

		String[][] seq = new String[2][n];
		boolean[][][] d = new boolean[m][n][n];
		int[][] c = new int[n][n]; //composite
		for(int i=0; i<n; i++) {
			seq[0][i] = br.readLine();
		}
		for(int i=0; i<n; i++) {
			seq[1][i] = br.readLine();
		}
		for(int i=0; i<m; i++) {
			for(int a=0; a<n; a++) {
				for(int b=0; b<n; b++) {
					if(seq[0][a].charAt(i) != seq[1][b].charAt(i)) {
						d[i][a][b] = true;
						c[a][b]++;
					}
				}
			}
		}
		int len = dpB(n,m,d,0,m-1,c);
		System.out.println(len);
	}

	//dp(n,m,d,a = start index, b = end index, c = composite)
	public static int dpB(int n,int m,boolean[][][] d, int a, int b, int[][] c) {
		try {
		int[][] q = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				q[i][j] = c[i][j];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(d[b][i][j]) q[i][j]--;
				if(q[i][j] < 0) return -1;
			}
		}
		int xx = dpB(n,m,d,a,b-1,q);
		int yy = dp(n,m,d,a,b,c);
		if(xx < 0) return yy;
		if(yy < 0) return xx;
		return Math.min(xx,yy);
		} catch(Exception e) {return -1;}
	}
	public static int dp(int n,int m,boolean[][][] d, int a, int b, int[][] c) {
		try{
		int[][] q = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				q[i][j] = c[i][j];
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(d[a][i][j]) q[i][j]--;
				if(q[i][j] < 0) return -1;
			}
		}
		int xx = dp(n,m,d,a+1,b,q);
		int yy = b-a; //remove or dont
		if(xx < 0) return yy;
		if(yy < 0) return xx;
		return Math.min(xx,yy);
		} catch(Exception e) {return -1;}
	}
}
/*
3 8
AATCCCAT
ACTTGCAA
GGTCGCAA
ACTCCCAG
ACTCGCAT
ACTTCCAT

*/