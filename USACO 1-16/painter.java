import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class painter {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		for(int tt=0; tt<t; tt++) {
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			int s = Integer.parseInt(arr[2]);
			char[][] b = new char[n][m];
			int[][] o = new int[n][m];

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					b[i][j] = '#';
					o[i][j] = 1001;
				}
			}

			for(int ss=0; ss<s; ss++) {
				arr = br.readLine().split(" ");
				char c = arr[4].charAt(0);
				int ord = Integer.parseInt(arr[5]);
				int[] coor = new int[4];
				for(int k=0; k<4; k++) coor[k] = Integer.parseInt(arr[k]);
				for(int i=coor[0]; i<=coor[2]; i++) {
					for(int j=coor[1]; j<=coor[3]; j++) {
						if(ord < o[i][j]) {
							o[i][j] = ord;
							b[i][j] = c;
						}
					}
				}
			}

			for(int i=0; i<n; i++) {
				System.out.printf("%s\n", new String(b[i]));
			}
			
		}
	}
}
/*
2
3 4 2
0 1 1 2 G 1
1 0 2 2 R 2
5 7 4
0 0 2 2 R 5
0 0 4 6 Y 100
2 2 4 4 G 37
0 6 0 6 R 21

*/