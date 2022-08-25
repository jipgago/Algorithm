package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_14888 {
	
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int N;
	static int number[];
	static int operator[] = new int[4];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		number = new int[N];
		StringTokenizer num = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < number.length; i++) {
			number[i] = Integer.parseInt(num.nextToken());
		}
		StringTokenizer oper = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < operator.length; i++) {
			operator[i] = Integer.parseInt(oper.nextToken());
		}
		dfs(number[0], 1);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}
	public static void dfs(int start, int depth) {
		if(depth == N) {
			MAX = Math.max(MAX, start);
			MIN = Math.min(MIN, start);
			return;
		}
		for(int i = 0 ; i < 4; i++) {
			if(operator[i] > 0 ) {
				operator[i]--;
				
				switch (i) {
				case 0:
					dfs(start + number[depth], depth+1);
					break;
				case 1:
					dfs(start - number[depth], depth+1);
					break;
				case 2:
					dfs(start * number[depth], depth+1);
					break;
				case 3:
					dfs(start / number[depth], depth+1);
					break;
				}
				operator[i]++;
			}
		}
	}

}
