package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_14500 {
	static int N;
	static int M;
	static int arr[][];
	static boolean isVisit[][];
	static int MAX = Integer.MIN_VALUE;
	
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		isVisit = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				isVisit[i][j] = true;
				solve(i, j, arr[i][j], 1);
			}
		}
		System.out.println(MAX);
			
		
	}
	public static void solve(int row, int col, int sum, int count) {
		if(count == 4) {
			MAX = Math.max(MAX, sum);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			int curRow = row + dx[i];
			int curCol = col + dy[i];
			if(curRow < 0 || curRow >= N || curCol < 0 || curCol >= M) {
				continue;
			}
			if(!isVisit[curRow][curCol]) {
				if(count==2) {
					isVisit[curRow][curCol] = true;
					solve(row, col, sum + arr[curRow][curCol], count+1);
					isVisit[curRow][curCol] = false;
				}
				isVisit[curRow][curCol] = true;
				solve(curRow, curCol, sum + arr[curRow][curCol], count + 1);
				isVisit[curRow][curCol] = false;
			}
		}
	}
}
