import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class trick {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		for(int tt=0; tt<t; tt++) {
			String[] arr = br.readLine().split(" ");
			//long m = Long.parseLong(arr[0]);
			//long n = Long.parseLong(arr[1]);
			int m = Integer.parseInt(arr[0]);
			int n = Integer.parseInt(arr[1]);
			long[] a = new long[m];
			arr = br.readLine().split(" ");
			a[0] = Long.parseLong(arr[0]);
			for(int i=1; i<m; i++) {
				a[i] = a[i-1] + Long.parseLong(arr[i]);
			}
			long greatest = a[n-1];
			for(int i=1; i<m-n+1; i++) {
				greatest = Math.max(greatest,a[i+n-1] - a[i-1]);
			}
			System.out.printf("%d\n", greatest);
		}
	}
}
/*
3
5 3
7 2 3 12 1
2 1
99 3
2 2
1 1

*/