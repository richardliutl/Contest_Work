import java.util.*;
import java.io.*;

public class fhsps21 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ii = Integer.parseInt(br.readLine());
        for(int i=0; i<ii; i++) {
            int ll = Integer.parseInt(br.readLine());
            String s = "";
            for(int l=0; l<ll; l++) {
                s += br.readLine()+" ";
            }
            s = s.replace("  "," ");
            s = s.replace("  "," ");
            s = s.replace("  "," ");
            if(s.charAt(s.length()-1) == ' ') s += " ";
            s = s.replace("  ","");

            String[]sente=s.split("\\. ");
            String[][]words=new String[sente.length][];
            for(int kg=0;kg<sente.length;kg++){
                words[kg]=sente[kg].split(" ");
            }
            boolean tol=true;
            System.out.printf("Paragraph #%d:\n",(i+1));
            for(int lol=1;lol<=sente.length;lol++){
                boolean tol2=true;
                String prevW=words[lol-1][0];
                for(int gg=0;gg<words[lol-1].length;gg++){
                    String temp=words[lol-1][gg];
                    if(temp.compareTo(prevW)<0){
                        tol2=false;
                        break;
                    }
                    else {
                        prevW=temp;
                    }
                }
                if(!tol2) {
                    System.out.printf("Sentence #%d: It's Broken.\n",lol);
                    tol=false;
                }
                else{
                    System.out.printf("Sentence #%d: Brett Flows!\n",lol);
                }
            }
            if(tol) System.out.println("MAX FLOW");
        }
    }
}