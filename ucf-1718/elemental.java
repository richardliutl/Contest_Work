import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class elemental {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ee = Integer.parseInt(br.readLine());
        int e = 0;
        while(ee != 0) {
            String a = "Not Elemental";
            String[] arr = br.readLine().split(" ");
            String word = br.readLine();
            if(isel(arr,word)) a = "Elemental";

            System.out.printf("Phrase #%d: %s\n\n", e+1, a);
            e++;
            ee = Integer.parseInt(br.readLine());
        }
    }

    public static boolean isel(String[] arr, String word) {
        // System.out.printf("Testing: %s: ", word);
        if(word.charAt(0) == ' ') return(isel(arr,word.substring(1)));
        for(int i=0; i<arr.length; i++) {
            if(arr[i].equals(word)) return(true);
            if(arr[i].length() < word.length())
                if(word.substring(0, arr[i].length()).equals(arr[i]))
                    if(isel(arr,word.substring(arr[i].length()))) return(true);
        }
        return(false);
    }
}