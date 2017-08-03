import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class platform {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		for(int tt=0; tt<t; tt++) {
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			int p = Integer.parseInt(arr[1]);
			int s = Integer.parseInt(arr[2]);
			int g = Integer.parseInt(arr[3]);
			ArrayList<Integer> q = new ArrayList<Integer>();
			int[][] b = new int[n][n];
			boolean[] v = new boolean[n];

			for(int nn=0; nn<n; nn++) {
				arr = br.readLine().split(" ");
				for(int i=0; i<n; i++) {
					b[nn][i] = Integer.parseInt(arr[i]);
				}
			}

			q.add(s);
			v[s] = true;
			while(!q.isEmpty()) {
				int pp = q.remove(0);
				for(int i=0; i<n; i++) {
					if(!v[i] && b[pp][i] <= p) {
						q.add(i);
						v[i] = true;
					}
				}
			}

			String sss = "IMPOSSIBLE";
			if(v[g]) sss = "EASY";

			System.out.printf("%s\n",sss);
		}
	}
}
/*
2
3 5 0 1
0 10 2
10 0 4
2 4 0
3 5 0 2
0 5 10
5 0 7
10 7 0

*/