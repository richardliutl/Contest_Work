/*
ID: rtliu1
LANG: JAVA
TASK: ride
*/
import java.util.*;
import java.io.*;

public class ride {
	public static int hash(String s) {
		int k = 1;
		for(int i=0; i<s.length(); i++) {
			k = (k*(s.charAt(i)-64))%47;
		}
		return k;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ride.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("ride.out"));
		int a = hash(br.readLine());
		int b = hash(br.readLine());
		if(a == b) {
			bw.write("GO\n");
		} else {
			bw.write("STAY\n");
		}
		br.close();
		bw.close();
	}
}