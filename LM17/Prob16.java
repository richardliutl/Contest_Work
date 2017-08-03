import java.io.*;
import java.util.*;
public class Prob16 {
    private static final String INPUT_FILE_NAME = "Prob15.in.txt";
	public static void main(String[] args) throws IOException{
        File inFile = new File(INPUT_FILE_NAME);
        FileReader fr = new FileReader(inFile);
        BufferedReader br = new BufferedReader(fr);
		int i0i = Integer.parseInt(br.readLine());
		for(int i0=0; i0<i0i; i0++) {
			String s=br.readLine();
			int[]counts=new int[10];
			for(int i=0;i<s.length();i++)
			{
				counts[Integer.parseInt(s.substring(i,i+1))]++;
			}
			int num5=0;
			int num4=0;
			int num3=0;
			int num2=0;
			int maxNum=0;
			int maxRun=0;
			int curRun=0;
			for(int i=1;i<10;i++){
				if(counts[i]>0){
					curRun++;
				}
				else{
					maxRun=Math.max(maxRun,curRun);
					curRun=0;
				}
				if(counts[i]>=5){
					num5++;
				}
				if(counts[i]>=4){
					num4++;
				}
				if(counts[i]>=3){
					num3++;
				}
				if(counts[i]>=2){
					num2++;
				}
				if(i>maxNum && counts[i]>0){
					maxNum=i;
				}
			}
		maxRun=Math.max(maxRun,curRun);	
		if(num5>0){
			System.out.println(s+" = FIVE OF A KIND");
		}
		else if(num4>0){
			System.out.println(s+" = FOUR OF A KIND");
		}
		else if(num3>0 && num2>1){
			System.out.println(s+" = FULL HOUSE");
		}
		else if(maxRun>4){
			System.out.println(s+" = STRAIGHT");
		}
		else if(num3>0){
			System.out.println(s+" = THREE OF A KIND");
		}
		else if(num2>1){
			System.out.println(s+" = TWO PAIR");
		}
		else if(num2>0){
			System.out.println(s+" = PAIR");
		}
		else{
			System.out.println(s+" = "+maxNum);
		}	
			}
		}
	}