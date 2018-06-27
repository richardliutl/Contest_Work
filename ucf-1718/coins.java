import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class coins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(br.readLine());
        for(int n=0; n<nn; n++) {
        	String w = "Bill";

        	String[] arr = br.readLine().split(" ");
        	int c = Integer.parseInt(arr[0]);
        	int k = Integer.parseInt(arr[1]);
        	String f = arr[2];
            if(f.equals("Bill")) {
            	if(c % (k+1) == 0) w = "Matthew";
            }
            if(f.equals("Matthew")) {
            	if(c % (k+1) > 0) w = "Matthew";
            }
            System.out.printf("Game #%d: %s\n", n+1, w);
        }
    }
}