package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1012 {
	private static StringBuilder sb = new StringBuilder();
	private static boolean[][] visit;
	private static int N, M, K;
	private static int[][] arr;
	final static int[][] moved = {{0, 1},{0, -1},{1, 0},{-1, 0}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());
		for(int i =0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = parseInt(st.nextToken());
			N = parseInt(st.nextToken());
			K = parseInt(st.nextToken());
			visit = new boolean[M][N];
			arr = new int[M][N];
			
			for(int j =0; j < K; j++) {
				st = new StringTokenizer(br.readLine());
				int x = parseInt(st.nextToken());
				int y = parseInt(st.nextToken());
				arr[x][y] = 1;
			}
			int answer = 0;
			for(int j = 0; j<M;j++) {
				for(int k = 0; k < N; k++) {
					if(visit[j][k] == false && arr[j][k] == 1) {
						answer++;
						DFS(j, k);
					}
				}
			}
			sb.append(answer).append("\n");
			
		}
		System.out.println(sb.toString());
	}
	
	public static void DFS(int x, int y) {
		visit[x][y] = true;
		
		
		for(int i = 0; i < moved.length; i++) {
			int curX, curY;
			curX = moved[i][0] + x;
			curY = moved[i][1] + y;
			if(isValid(curX, curY) && visit[curX][curY] == false && arr[curX][curY] == 1) {
				visit[curX][curY] = true;
				DFS(curX, curY);
			}
		}
	}
	public static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < M && y < N;
	}
	
	public static int parseInt(String a) {
		return Integer.parseInt(a);
	}

}
