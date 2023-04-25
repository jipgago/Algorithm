package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_7576 {
	private static int N, M;
	private static int[][] tomato;
	private static boolean[][] isCheck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tomato = new int[M][N];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	}
	public static int Solution() {
		int answer = 0;
		
		return answer;
	}

}
