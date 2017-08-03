import java.util.*;
import java.io.*;

public class hyenas {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			int rr = Integer.parseInt(br.readLine().split(" ")[0]);
			int h = 0;
			for(int r=0; r<rr; r++) {
				String a = br.readLine();
				h += a.length() - a.replace("H","").length();
			}
			System.out.printf("Location #%d: %d\n",(i+1),h);
		}
	}
}