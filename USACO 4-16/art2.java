import java.io.*;
import java.util.ArrayList;

public class art2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("art2.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("art2.out"));
		int n = Integer.parseInt(br.readLine());
		ArrayList<int[]> a = new ArrayList<int[]>(); //stores painting as (color, rounds)
		int[] b = new int[n+1]; //stores first instance of b, -> -1 if cannot be used, -2 not set
		int r = 0;
		boolean nonzero = false; boolean bad = false;
		for(int i=0; i<=n; i++) b[i] = -2;
		b[0] = 0;
		a.add(new int[]{0,0}); //append 0,0 to front.
		for(int i=0; i<n; i++) { //read n lines of input
			a.add(new int[]{Integer.parseInt(br.readLine()),0});
			if(a.get(a.size()-1)[0] > 0) nonzero = true;
			if(b[a.get(a.size()-1)[0]]==-2) {
				b[a.get(a.size()-1)[0]] = a.size()-1;
			} else if(b[a.get(a.size()-1)[0]]==-1) {
				r = -1;
				bad = true;
				break;
			} else if(b[a.get(a.size()-1)[0]]==a.size()-2) {
				a.remove(a.size()-1);
			} else {
				dp(a,b,b[a.get(a.size()-1)[0]]);
			}
		}
		a.add(new int[]{0,0}); //append 0,0 to end
		dp(a,b,b[a.get(a.size()-1)[0]]);
		
		if(bad) bw.write(r+"\n");
		else if(!nonzero) bw.write("0\n");
		else bw.write(a.get(0)[1]+"\n");

		bw.close();
		br.close();
	}

	// dp(a = painting, b = first instance, j = first instance of k)
	public static void dp(ArrayList<int[]> a, int[] b, int j) {
		int[] c = new int[]{a.get(j)[0], 0};
		a.remove(a.size()-1);
		for(int i=a.size()-1; i>j; i--) {
			int[] p = a.remove(i);
			c[1] = Math.max(c[1], p[1]);
			b[p[0]] = -1;
		}
		c[1] = Math.max(c[1]+1,a.get(j)[1]);
		a.set(j, c);
	}
}