package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_10989 {
	static int N;
	static int[] num;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(num);
		for(int i = 0; i < num.length; i++) {
			sb.append(num[i]).append('\n');
		}
		System.out.println(sb);
	}

}
