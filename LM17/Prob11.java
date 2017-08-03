import java.io.*;
import java.util.*;
public class Prob11 {
	public static String rev(String lol){
				String letts="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
				String nString="";
				for(int i=0;i<lol.length();i++){
					if(letts.contains(lol.substring(i,i+1))){
						nString+=lol.substring(i,i+1);
					}
				}
			return nString;
	}
	public static String reverse(String lol){
		String nString="";
		for(int i=lol.length();i>0;i--){
			nString+=lol.substring(i-1,i);
		}
		return nString;
	}
    private static final String INPUT_FILE_NAME = "Prob11.in.txt";
	public static void main(String[] args) throws IOException{
        File inFile = new File(INPUT_FILE_NAME);
        FileReader fr = new FileReader(inFile);
        BufferedReader br = new BufferedReader(fr);
		int i0i = Integer.parseInt(br.readLine());
		String letts="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM";
		for(int i0=0; i0<i0i; i0++) {
			String s=br.readLine();
			String[]lmao=new String[s.length()];
			for(int i=0;i<lmao.length;i++){
				if(letts.contains(s.substring(i,i+1))){
					if(s.substring(i,i+1).equals(s.substring(i,i+1).toUpperCase())){
						lmao[i]="up";
					}
					else{
						lmao[i]="low";
					}
				}
				else{
					lmao[i]=s.substring(i,i+1);
				}
			}
			String[]words=s.split(" ");
			String allw="";
			for(int i=0;i<words.length;i++){
				String ss=rev(words[i]);
				ss=reverse(ss);
				//char[]wtf=rev(words[i]).toCharArray();
				//words[i]=wtf.toString();
				words[i]=ss;
				allw+=words[i];
			}
			String out="";
			int pos=0;
			for(int i=0;i<lmao.length;i++){
				if(lmao[i].equals("up")){
					out+=allw.substring(pos,pos+1).toUpperCase();
					pos++;
				}
				else if(lmao[i].equals("low")){
					out+=allw.substring(pos,pos+1).toLowerCase();
					pos++;
				}
				else{
					out+=lmao[i];
				}
			}
			System.out.println(out);
			}
		}
	}