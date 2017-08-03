import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

public class assembly {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		for(int tt=0; tt<t; tt++) {
			int[] r = new int[17];
			ArrayList<String> label = new ArrayList<String>();
			ArrayList<Integer> labeln = new ArrayList<Integer>();
			int n = Integer.parseInt(br.readLine());
			String[] arg = new String[n];
			
			int i;
			for(i=0; i<n; i++) {
				arg[i] = br.readLine();
				if(arg[i].contains(":")) { //label
					label.add(arg[i].replace(":",""));
					labeln.add(i);
				} 
			}
			i = 0;
			while(i<n) {
				String a = arg[i];
				if(a.contains(":")) {i++;}
				else if(a.charAt(0) == 'a') { //add
					String[] temp = a.split(", ");
					int arg1 = Integer.parseInt(temp[0].split("\\$")[1]);
					String arg2 = temp[1];
					if(arg2.contains("$")) {
						int arg3 = Integer.parseInt(arg2.replace("$",""));
						r[arg1] += r[arg3];
					} else {
						int arg3 = Integer.parseInt(arg2);
						r[arg1] += arg3;
					}
					i++;
				} else if(a.charAt(0) == 'j') { //jne
					String[] temp = a.split(", ");
					int arg1 = Integer.parseInt(temp[0].split("\\$")[1]);
					int arg2 = Integer.parseInt(temp[1].replace("$",""));
					if(r[arg1] != r[arg2]) {
						i = labeln.get(label.indexOf(temp[2]));
					} else {
						i++;
					}
				} else if(a.charAt(0) == 'm') { //mov
					String[] temp = a.split(", ");
					int arg1 = Integer.parseInt(temp[0].split("\\$")[1]);
					String arg2 = temp[1];
					if(arg2.contains("$")) {
						int arg3 = Integer.parseInt(arg2.replace("$",""));
						r[arg1] = r[arg3];
					} else {
						int arg3 = Integer.parseInt(arg2);
						r[arg1] = arg3;
					}
					i++;
				}
			}
			for(i=1; i<16; i++)
				System.out.printf("%d ", r[i]);
			System.out.printf("%d\n", r[16]);
		}
	}
}
/*
6
3
add $1, 7
add $2, 4
add $2, $1
7
unusedlabel:
add $1, 7
add $2, 4
jne $1, $2, alabel
add $1, $2
alabel:
add $1, 99
6
add $1, 9
add $3, 1
multiplyloop:
add $3, $3
add $2, 1
jne $2, $1, multiplyloop
1
mov $2, 3
2
add $1, 7
mov $2, $1
11
add $1, 10
add $3, 1
add $4, 1
multiplyloop:
mov $5, 0
add $5, $4
add $5, $3
mov $3, $4
mov $4, $5
add $2, 1
jne $2, $1, multiplyloop

*/