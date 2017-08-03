import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class amtrack {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int n0=0; n0<n; n0++) {
			String[] a = br.readLine().split(" ");
			int[] times = new int[4];
			for(int i=0; i<4; i++) {
				String[] t = a[i].split(":");
				times[i] = 60*Integer.parseInt(t[0]) + Integer.parseInt(t[1]);
			}
			int n1 = (times[1] + 1440 - times[0]) % 1440;
			int n2 = (times[3] + 1440 - times[2]) % 1440;
			if(n1 > n2) {
				System.out.println("Silver Star");
			} else if(n1 < n2) {
				System.out.println("Silver Meteor");
			} else {
				System.out.println("Cannot tell");
			}
		}
	}
}
/*
2
08:00 12:00 09:00 11:00
11:00 12:00 13:00 15:00 

*/