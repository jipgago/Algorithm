package ailgorism;

import java.io.*;

public class baekjun_17427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long res = 0;
		
		for(int i = 1; i < N; i++) {
			res+= i * (N/i);
		}
		System.out.println(res);
	}

}
