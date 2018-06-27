import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class wipeout {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ee = Integer.parseInt(br.readLine());
        for(int e=0; e<ee; e++) {
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int s = Integer.parseInt(arr[2]);


            // int[][][] mapDiff = new int[n+1][n+1][s+1];
            int[][] mapDiff = new int[n+1][n+1];
            int[][][] mapTime = new int[n+1][n+1][s+1];

            ArrayList<Integer> al = new ArrayList<Integer>();

            for(int i=0; i<m; i++) {
                arr = br.readLine().split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);
                int d = Integer.parseInt(arr[2]);
                int t = Integer.parseInt(arr[3]);
                // mapDiff[a][b][0] = d;
                // mapTime[a][b][0] = t;

                mapDiff[a][b] = d;
                mapTime[a][b][d] = t;
                if(a==1) al.add(b);
            }

            while(mapDiff[1][n] == 0) {
                int check = al.remove(0);
                for(int i=1; i<=n; i++) {
                    if(mapDiff[check][i] > 0) {
                        mapTime[1][i] = mapTime[1][check]+mapTime[check][i];
                        mapDiff[1][i] = mapDiff[1][check]+mapDiff[check][i];
                        al.add(i);
                    }
                }
                if(al.isEmpty()) {
                    mapDiff[1][n] = s;
                }
            }

            if(mapDiff[1][n] < s)
                System.out.printf("Episode #%d: %d\n", e+1, mapTime[1][n]);
            else
                System.out.printf("Episode #%d: Wipeout!\n", e+1);
        }
    }
}
/*
2
3 3 10
1 2 5 1
2 3 6 1
2 3 4 3
3 3 10
1 2 5 1
2 3 6 1
3 2 4 1

*/