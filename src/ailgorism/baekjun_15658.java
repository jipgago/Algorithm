package ailgorism;

import java.util.*;
import java.io.*;
public class baekjun_15658 {
	static int MAX = Integer.MIN_VALUE;
	static int MIN = Integer.MAX_VALUE;
	static int N;
	static int[] num;
	static int[] operator = new int[4];
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < operator.length; i++) {
			operator[i] = Integer.parseInt(st.nextToken());
		}
		bfs(num[0], 1);
		print();
	}
	
	public static void bfs(int start, int depth) {
		if(depth == N) {
			MAX = Math.max(MAX, start);
			MIN = Math.min(MIN, start);
			return;
		}
		for(int i = 0; i < operator.length; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
				case 0:
					bfs(start + num[depth], depth + 1);
					break;
				case 1:
					bfs(start - num[depth], depth + 1 );
					break;
				case 2:
					bfs(start * num[depth], depth + 1);
					break;
				case 3:
					bfs(start / num[depth], depth + 1);
					break;
				}
				operator[i]++;
			}
		}
	}
	public static void print() {
		System.out.println(MAX);
		System.out.println(MIN);
	}

}
