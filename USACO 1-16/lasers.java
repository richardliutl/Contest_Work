/*
ID: rtliu1
LANG: JAVA
TASK: lasers
*/
import java.util.*;
import java.io.*;

public class lasers {
	public static int[] getCoor(int[][] coors, int n) {
		int[] coor = new int[coors[n].length];
		for(int i=0; i<coor.length; i++) {
			coor[i] = coors[n][i];
		}
		return coor;
	}
	public static void main(String args[]) throws IOException {
		int bound = 70000000;
		int[] h = new int[bound];
		int[] v = new int[bound];
		for(int i=0; i<bound; i++) {
			h[i] = -1;
			v[i] = -1;
		}
		BufferedReader br = new BufferedReader(new FileReader("lasers.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("lasers.out"));
		String[] a = br.readLine().split(" ");
		int[] n = new int[a.length];
		for(int i=0; i<a.length; i++) {
			n[i] = Integer.parseInt(a[i]);
		}
		int[] coorL = new int[]{n[1],n[2]};
		v[coorL[0]] = 0;
		h[coorL[1]] = 0;
		int[] coorB = new int[]{n[3],n[4]};
		int[][] coors = new int[n[0]][5]; //Array of {x,y,# mirrors to reach here,output 0 = horizontal or 1 = vertical,pos}
		ArrayList<int[]> toCheck = new ArrayList<int[]>();
		for(int i=0; i<n[0]; i++) {
			a = br.readLine().split(" ");
			coors[i][0] = Integer.parseInt(a[0]);
			coors[i][1] = Integer.parseInt(a[1]);
			coors[i][2] = -1;
			coors[i][3] = -1;
			coors[i][4] = i;
			if(coors[i][0] == coorL[0]) {
				coors[i][2] = 0;
				coors[i][3] = 0;
				h[coors[i][1]] = 1;
				toCheck.add(new int[]{0,coors[i][1]}); //{a.b} a = 0 horizontal, b = y-value
			} else if(coors[i][1] == coorL[1]) {
				coors[i][2] = 0;
				coors[i][3] = 1;
				v[coors[i][0]] = 1;
				toCheck.add(new int[]{1,coors[i][0]}); //{a.b} a = 1 vertical, b = x-value
			}
		}
		boolean barn = false;
		int m = -1;
		if(coorL[0] == coorB[0] || coorL[1] == coorB[1]) {
			barn = true;
			m = 0;
		}
		while(!barn && !toCheck.isEmpty()) {
			int[] line = toCheck.remove(0);
			//System.out.printf(">>%d %d\n",line[0],line[1]);
			if(line[0] == 1) { // vertical
				if(line[1] == coorB[0]) {
					barn = true;
					m = v[line[1]];
				} else {
					for(int i=0; i<n[0]; i++) {
						if(coors[i][0] == line[1] && h[coors[i][1]] == -1) {
							h[coors[i][1]] = v[line[1]] + 1;
							toCheck.add(new int[]{0,coors[i][1]});
						}
					}
				}
			} else if(line[0] == 0) { // horizontal
				if(line[1] == coorB[1]) {
					barn = true;
					m = h[line[1]];
				} else {
					for(int i=0; i<n[0]; i++) {
						if(coors[i][1] == line[1] && v[coors[i][0]] == -1) {
							v[coors[i][0]] = h[line[1]] + 1;
							toCheck.add(new int[]{1,coors[i][0]});
						}
					}
				}
			}
		}
		bw.write(String.format("%d\n",m));
		br.close();
		bw.close();
	}
}