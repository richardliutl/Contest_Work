import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class bunker {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ee = Integer.parseInt(br.readLine());
        for(int e=0; e<ee; e++) {
            String[] arr = br.readLine().split(" ");
            int r = Integer.parseInt(arr[0]);
            int c = Integer.parseInt(arr[1]);
            double[] cc = new double[c];
            arr = br.readLine().split(" ");

            for(int i=0; i<c; i++) cc[i] = Double.parseDouble(arr[i]);

            double least_d = 0;

            for(int i=0; i<c; i++) {
                double a_d = 0;
                for(int k=0; k<c; k++) {
                    if(k != i) {
                        double ang = Math.abs(cc[k] - cc[i]);
                        if(ang>180) ang = 360 - ang;

                        a_d += ang;
                    } 
                }
                if(i==0) least_d = a_d;
                else {
                    if(a_d < least_d) least_d = a_d;
                }
            }

            System.out.printf("Tree #%d: %.3f\n", e+1, least_d*r*Math.PI/180.0);
        }
    }
}