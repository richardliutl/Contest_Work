import java.util.*;
import java.io.*;

public class keyboard {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String[] a = br.readLine().split(" ");
			int h = 0;
			int nn = Integer.parseInt(a[0]) - 1;
			int cn = translate(a[1]);
			for(int n=0; n<nn; n++) {
				int note = translate(a[n+2]);
				if(note > cn) {
					int d1 = note - cn;
					int d2 = Math.abs(d1 - 12);
					if(d1 < d2) {
						h += d1;
					} else {
						h += d2;
					}
				} else {
					int d1 = cn - note;
					int d2 = Math.abs(d1 - 12);
					if(d1 < d2) {
						h += d1;
					} else {
						h += d2;
					}
				}
				cn = note;
			}
			System.out.printf("Song #%d: %d\n",(i+1),h);
		}
	}
	public static int translate(String note) {
		String kb = "CHDHEFHGHAHB";
		int n = kb.indexOf(note.charAt(0)+"");
		if(note.length() == 1) {
			return n;
		} else {
			String o = note.charAt(1)+"";
			if(o.equals("#")) {
				return n+1;
			} else {
				return n-1;
			}
		}
	}
}