import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class unite {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ee = Integer.parseInt(br.readLine());
        for(int e=0; e<ee; e++) {
            int n = Integer.parseInt(br.readLine());
            int[][] coords = new int[n][3];

            for(int i=0; i<n; i++) {
                String[] arr = br.readLine().split(" ");
                coords[i][0] = Integer.parseInt(arr[0]);
                coords[i][1] = Integer.parseInt(arr[1]);
                coords[i][2] = Integer.parseInt(arr[2]);
            }

            long[][] map = new long[n][n];

            for(int i=0; i<n-1; i++) {
                map[i][i] = -1;
                for(int j=i+1; j<n; j++) {
                    long dist = 0;
                    for(int k=0; k<3; k++) dist += (coords[i][k]-coords[j][k])*(coords[i][k]-coords[j][k]);
                    map[i][j] = dist;
                    map[j][i] = dist;
                }
            }

            int nn = 1;
            map[0][0] = 0;
            map[n-1][n-1] = -1;
            long d = 0;

            while(nn < n) {
                // for(int i=0; i<n; i++) {
                //     for(int j=0; j<n; j++)
                //         System.out.print(map[i][j]+" ");
                //     System.out.print("\n");   
                // }
                int least = -1;
                long leastd = -1;
                for(int t=0; t<n; t++) {
                    if(map[t][t] == 0) {
                        for(int i=0; i<n; i++) {
                            if(map[i][i] == -1) {
                                if(leastd < 0) leastd = map[t][i];
                                if(least < 0) least = i;
                                if(map[t][i] < leastd) {
                                    leastd = map[t][i];
                                    least = i;
                                }
                            }
                        }
                    }
                }
                map[least][least] = 0;
                d += leastd;
                nn++;
            }
            System.out.printf("Universe #%d: %d\n", e+1, d);
        }
    }
}
/*
2
3
0 0 0
0 0 2
0 0 -2
7
0 0 5
0 3 0
0 3 5
2 0 0
2 0 5
2 3 0
2 3 5

*/