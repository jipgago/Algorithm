package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_11728 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] index =new int[N + K];
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N+K; i++) {
			if(i == N) st = new StringTokenizer(br.readLine());
			index[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(index);
		StringBuilder sb = new StringBuilder();
		for(int i =0; i < N+K; i++) {
			sb.append(index[i]).append(" ");
		}
		System.out.println(sb.toString());
	}

}
