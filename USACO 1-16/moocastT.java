import java.util.*;
import java.io.*;

public class moocastT {
	public static int hash(String s) {
		int k = 1;
		for(int i=0; i<s.length(); i++) {
			k = (k*(s.charAt(i)-64))%47;
		}
		return k;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = integer.parseInt(br.readLine());
		int[][] coors = new int[N][2];
		for(int i=0; i<N; i++) {
			String[] a = br.readLine().split(" ");
			coors[i][0] = Integer.parseInt(a[0]);
			coors[i][1] = Integer.parseInt(a[1]);
		}
	}
}