import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class lerps {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ee = Integer.parseInt(br.readLine());
        for(int e=0; e<ee; e++) {
            int maxLerps = 0;

            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            int[] lerps = new int[n];
            int sum = 0;
            for(int i=0; i<n; i++) {
                lerps[i] = Integer.parseInt(arr[i]);
                sum += lerps[i];
            }

            if(sum % 2 == 0) maxLerps = sum;
            else {
                int oddCount = 0;
                for(int i=0; i<n; i++) {
                    if(lerps[i] % 2 == 1) {
                        if(oddCount % 2 == 0) {
                            if(sum - lerps[i] > maxLerps) maxLerps = sum - lerps[i];
                        }
                        oddCount++;
                    }
                }

            }

            System.out.printf("Environment #%d: %d lerps\n", e+1, maxLerps);
        }
    }
}