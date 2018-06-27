import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class optimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ee = Integer.parseInt(br.readLine());
        for(int e=0; e<ee; e++) {
            String a = "Oh no, the autobots are doomed!";
            int n = Integer.parseInt(br.readLine());

            if(isPrime(n))
                if(permutation(Integer.toString(n), Integer.toString(n)))
                    a = "Autobots, roll out!";
            System.out.printf("Battle #%d: %s\n", e+1, a);
        }
    }
    
    public static boolean permutation(String str, String orig) { 
        return(permutation("", str, orig));
    }

    private static boolean permutation(String prefix, String str, String orig) {
        int n = str.length();
        if (n == 0) {
            // System.out.printf("Testing: %s: ", prefix);
            if(!prefix.equals(orig))
                if(prefix.charAt(0) != '0')
                    if(isPrime(Integer.parseInt(prefix)))
                        return(true);
            return(false);
        }
        else {
            for (int i = 0; i < n; i++)
                if(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), orig))
                    return(true);
        }
        return(false);
    }

    public static boolean isPrime(int n) {
        //check if n is a multiple of 2
        if (n%2==0) return false;
        //if not, then just check the odds
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
}