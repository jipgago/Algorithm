package ailgorism;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class baekjun_5052 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb =new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while(N-- > 0) {
			int K = Integer.parseInt(br.readLine());
			String[] index = new String[K];
			for(int i = 0; i < K; i++) 	index[i] = br.readLine();
			Arrays.sort(index);
			if(isConsistent(K, index)) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb.toString());

	}
	public static boolean isConsistent(int N, String[] phoneNum) {
		
		for(int i = 0; i < N-1; i ++) {
			if(phoneNum[i+1].startsWith(phoneNum[i])) return false;
		}
		
		return true;
	}	
}
