import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class visitfj {
	public static void main(String args[]) throws IOException {
		int[][] m = new int[][]{{3,0},{2,1},{1,2},{0,3},{-1,2},{-2,1},{-3,0},{-2,-1},{-1,-2},{0,-3},{1,-2},{2,-1},{1,0},{0,1},{-1,0},{0,-1}};
		BufferedReader br = new BufferedReader(new FileReader("visitfj.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("visitfj.out"));
		String[] arr = br.readLine().split(" ");
		int n0 = Integer.parseInt(arr[0]);
		int t0 = Integer.parseInt(arr[1]);
		int[][] f0 = new int[n0][n0];
		int[][] f = new int[n0][n0];
		for(int i=0; i<n0; i++) {
			arr = br.readLine().split(" ");
			for(int j=0; j<n0; j++) {
				f0[i][j] = Integer.parseInt(arr[j]);
			}
		}
		ArrayList<int[]> a = new ArrayList<int[]>();
		a.add(new int[]{0,0});
		while(!a.isEmpty()) {
			int[] c = a.remove(0);
			for(int i=0; i<16; i++) {
				int[] c0 = new int[]{c[0]+m[i][0], c[1]+m[i][1]};
				if(c0[0] < 0 || c0[0] >= n0 || c0[1] < 0 || c0[1] >= n0){
					//System.out.println("Dropped: "+c0[0]+","+c0[1]);
					continue;
				}
				if(c0[0] + c0[1] > 2*n0-5) {
					int t = f[c[0]][c[1]] + 3*t0 + f0[c0[0]][c0[1]] + t0*(2*n0 - (c0[0] + c0[1] + 2));
					//System.out.println("At "+c0[0]+","+c0[1]+" has "+t);
					if(f[n0-1][n0-1] == 0 || t < f[n0-1][n0-1])
						f[n0-1][n0-1] = t;
				} else {
					int t = f[c[0]][c[1]] + 3*t0 + f0[c0[0]][c0[1]];
					if(f[c0[0]][c0[1]] == 0 || t < f[c0[0]][c0[1]]) {
						f[c0[0]][c0[1]] = t;
						a.add(new int[]{c0[0], c0[1]});
						//System.out.println("Added: "+c0[0]+","+c0[1]);
					}
				}
			}
		}
		/*
		for(int i=0; i<n0; i++) {
			for(int j=0; j<n0; j++) {
				System.out.print(f[i][j] + " ");
			}
			System.out.println();
		}
		*/
		bw.write(f[n0-1][n0-1]+"\n");
		br.close();
		bw.close();
	}
}
/*
4 2
30 92 36 10
38 85 60 16
41 13 5 68
20 97 13 80

*/