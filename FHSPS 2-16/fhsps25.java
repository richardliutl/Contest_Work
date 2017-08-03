import java.util.*;
import java.io.*;

public class fhsps25 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ii = Integer.parseInt(br.readLine());
		for(int i=0; i<ii; i++) {
			String[] a = br.readLine().split(" ");
			int rr = Integer.parseInt(a[1]);
			int cc = Integer.parseInt(a[0]);
			char[][] room = new char[rr][cc];
			int s = 0;
			ArrayList<int[]> coors = new ArrayList<int[]>();
			for(int r=0; r<rr; r++) {
				String tempp = br.readLine();
				for(int c=0; c<cc; c++) {
					//System.out.printf("%d of %s\n",c,tempp);
					room[r][c] = tempp.charAt(c);
					if(tempp.charAt(c) == 's') {
						s++;
						room[r][c] = 'e';
						coors.add(new int[]{r,c});
					}
				}
			}
			boolean done = false;
			while(!done) {
				while(!coors.isEmpty()) {
					int[] c = coors.remove(0);
					int[][] tr = new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
					for(int k=0; k<4; k++) {
						try{
							int[] newc = new int[]{c[0]+tr[k][0],c[1]+tr[k][1]};
							if(room[newc[0]][newc[1]] == 'w') {
								room[newc[0]][newc[1]] = 'e';
								coors.add(new int[]{newc[0],newc[1]});
							}
						} catch(Exception e) {}
					}
				}
				int[] next = new int[]{-1,-1};
				boolean connn = false;
				for(int x=0; x<room.length; x++) {
					for(int y=0; y<room[x].length; y++) {
						if(room[x][y] == 'w') {
							next = new int[]{x,y};
							connn = true;
						}
					}
				}
				if(!connn) {
					done = true;
				} else {
					room[next[0]][next[1]] = 'e';
					coors.add(next);
					s++;
				}
			}
			// for(int x=0; x<room.length; x++) {
			// 	for(int y=0; y<room[x].length; y++) {
			// 		System.out.printf("%s ",room[x][y]);
			// 	}
			// 	System.out.println();
			// }
			System.out.printf("%d\n",s);
		}
	}
}