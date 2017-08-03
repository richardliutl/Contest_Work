import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;


public class discounts {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long t = Long.parseLong(br.readLine());
		for(int tt=0; tt<t; tt++) {
			String[] arr = br.readLine().split(" ");
			//long m = Long.parseLong(arr[0]);
			//long n = Long.parseLong(arr[1]);
			int n = Integer.parseInt(arr[0]);
			int x = Integer.parseInt(arr[1]);
			double sum = 0;
			for(int i=0; i<n; i++) {
				arr = br.readLine().split(" ");
				sum += 1.0*Integer.parseInt(arr[0])*Double.parseDouble(arr[2]);
			}
			String s = String.valueOf(sum*(1.0-0.01*x)).replace("[0]*$", "").replaceAll("\\.$", "");
			System.out.printf("%s\n", s);
		}
	}
}
/*
2
3 20
1 milk 1.20
1 flour 5.00
2 sugar 3.40
2 7
5 eggs 3.20
2 butter 1.59

*/