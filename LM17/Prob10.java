import java.io.*;
import java.util.*;
public class Prob10 {
    private static final String INPUT_FILE_NAME = "Prob10.in.txt";
    public static char flip(char s) {
    	if(s <= 90 && s >= 65) {
    		return((s+"").toLowerCase().charAt(0));
    	}
    	return((s+"").toUpperCase().charAt(0));
    }

	public static void main(String[] args) throws IOException{
        File inFile = new File(INPUT_FILE_NAME);
        FileReader fr = new FileReader(inFile);
        BufferedReader br = new BufferedReader(fr);

		String si = "wertyuiopWERTYUIOPsdfghjklSDFGHJKLxcvbnm,.XCVBNM<>? ";
		String sf = "qwertyuioQWERTYUIOasdfghjkASDFGHJKzxcvbnm,ZXCVBNM<> ";
		int i0i = Integer.parseInt(br.readLine());
		for(int i0=0; i0<i0i; i0++) {
			int i1i = Integer.parseInt(br.readLine());
			boolean flip = false;
			for(int i1=0; i1<i1i; i1++) {
				String s = br.readLine();
				String o = "";
				for(int i=0; i<s.length(); i++) {
					char c = s.charAt(i);
					if(si.contains(c+"")) {
						o += !flip ? sf.charAt(si.indexOf(c)) : flip(sf.charAt(si.indexOf(c)));
					} else if(c == 'q' || c == 'Q') {
						o += "    ";
					} else if(c == 'a' || c == 'A') {
						flip = !flip;
					} else if(c == 'z' || c == 'Z') {
						//xd
					}
				}
				System.out.println(o);
			}
		}
	}
}