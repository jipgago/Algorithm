package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_25305 {
	static int N, K;
	static Integer[] score;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		score = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			score[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(score, Collections.reverseOrder());
		System.out.println(score[K-1]);
	}

}
