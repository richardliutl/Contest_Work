import java.util.*;
import java.io.*;

public class lasersT {
	public static int[] getCoor(int[][] coors, int n) {
		int[] coor = new int[coors[n].length];
		for(int i=0; i<coor.length; i++) {
			coor[i] = coors[n][i];
		}
		return coor;
	}
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		int[] n = new int[a.length];
		for(int i=0; i<a.length; i++) {
			n[i] = Integer.parseInt(a[i]);
		}
		int[] coorL = new int[]{n[1],n[2]};
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
				toCheck.add(getCoor(coors,i));
			} else if(coors[i][1] == coorL[1]) {
				coors[i][2] = 0;
				coors[i][3] = 1;
				toCheck.add(getCoor(coors,i));
			}
		}
		boolean barn = false;
		int m = -1;
		if(coorL[0] == coorB[0] || coorL[1] == coorB[1]) {
			barn = true;
			m = 0;
		}
		while(!barn && !toCheck.isEmpty()) {
			int[] coor = toCheck.remove(0);
			if(coors[coor[4]][2] > -2) {
				System.out.printf(">>%d %d %d %d\n",coor[0],coor[1],coor[2],coor[3]);
				if(coor[3] == 1) {
					if(coor[0] == coorB[0]) {
						barn = true;
						m = coor[2] + 1;
					} else {
						for(int i=0; i<n[0]; i++) {
							if(coors[i][0] == coor[0] && (coors[i][2] == -1 /*|| coors[i][2] > coor[2]*/) && coors[i][1] != coor[1]) {
								coors[i][2] = coor[2] + 1;
								coors[i][3] = 1 - coor[3];
								toCheck.add(getCoor(coors,i));
							}
						}
					}
				} else if(coor[3] == 0) {
					if(coor[1] == coorB[1]) {
						barn = true;
						m = coor[2] + 1;
					} else {
						for(int i=0; i<n[0]; i++) {
							if(coors[i][1] == coor[1] && (coors[i][2] == -1 /*|| coors[i][2] > coor[2]*/) && coors[i][0] != coor[0]) {
								coors[i][2] = coor[2] + 1;
								coors[i][3] = 1 - coor[3];
								toCheck.add(getCoor(coors,i));
							}
						}
					}
				}
			}
		}
		System.out.printf("%d\n",m);
	}
}