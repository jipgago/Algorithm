package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1339 {

	static String alpha;
	static int N, answer, n;
	static int num[] = new int[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		for(int i = 0 ; i < N; i++) {
			alpha = br.readLine();
			for(int j = 0; j < alpha.length(); j++) {
				num[alpha.charAt(j) - 'A'] += (Math.pow(10, alpha.length() - j - 1)); 
			}
		}
		Arrays.sort(num);
//		System.out.println(Arrays.toString(num));
		n = 9;
		
		for(int i = 25; i >= 0; i--) {
			if(num[i] == 0) {
				continue;
			}
			answer += (num[i] * n);
			n--;
		}
		System.out.println(answer);

	}
}