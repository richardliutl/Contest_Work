import java.util.*;
import java.io.*;

public class hello {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Hello World!");
		String a = br.readLine();
		System.out.printf("%s %s %s",a,a,a);
	}
}