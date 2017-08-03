import java.util.*;
import java.io.*;

public class rideT {
	public static int hash(String s) {
		int k = 1;
		for(int i=0; i<s.length(); i++) {
			k = (k*(s.charAt(i)-64))%47;
		}
		return k;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = hash(br.readLine());
		int b = hash(br.readLine());
		if(a == b) {
			System.out.println("GO");
		} else {
			System.out.println("STAY");
		}
	}
}