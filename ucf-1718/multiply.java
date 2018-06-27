import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class multiply {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(br.readLine());
        for(int n=0; n<nn; n++) {
            String[] mmS = br.readLine().split(" ");
            System.out.println(Integer.parseInt(mmS[0])*Integer.parseInt(mmS[1]));
        }
    }
}