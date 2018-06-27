import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class dinner {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nn = Integer.parseInt(br.readLine());
        for(int n=0; n<nn; n++) {
        	String list = "";
            int listL = 0;

            int rr = Integer.parseInt(br.readLine());
            for(int r=0; r<rr; r++) {
                String name = br.readLine();
                boolean valid = false;

                int nameL = name.length();
                int vowel = name.length();

                String vowels = "aeiou";
                String nameR = name;
                for(int i=0; i<5; i++) nameR = nameR.replace(vowels.charAt(i)+"", "");
                vowel -= nameR.length();

                // System.out.printf("%s: %d",name,nameL);

                // System.out.printf(": %d", name.length() - name.replace("y","").length());
                if((name.length() - name.replace("y","").length()) % 2 == 0) {
                    vowel += (int)((name.length() - name.replace("y","").length())/2);

                    // System.out.printf(": %d",vowel);

                    if(" 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 ".contains(" "+Integer.toString(nameL)+" ")) {
                        if(vowel % 2 == 1)
                            valid = true;
                    }
                    if(" 0 1 4 9 16 25 36 49 ".contains(" "+Integer.toString(nameL)+" "))
                        if(" 0 1 4 9 16 25 36 49 ".contains(" "+Integer.toString(vowel)+" "))
                            valid = true;
                }

                if(valid) {
                    list += name+"\n";
                    listL++;
                }

                // System.out.printf("\n");
            }

            if(listL > 0)
                System.out.printf("Practice #%d: %d valid options\n%s\n", n+1, listL, list);
            else
                System.out.printf("Practice #%d: It's hopeless!\n\n", n+1);
        }
    }
}