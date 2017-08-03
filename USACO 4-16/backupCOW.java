import java.io.*;

public class cownomics {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("cownomics.out"));
		String[] a = br.readLine().split(" ");
		int n = Integer.parseInt(a[0]);
		int m = Integer.parseInt(a[1]);

		String[] seq = new String[2*n];
		for(int i=0; i<2*n; i++) {
			seq[i] = br.readLine();
		}
		bw.write((n+1)+"\n");

		bw.close();
		br.close();
	}
}