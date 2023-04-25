package ailgorism;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class baekjun_14889 {
	
	public static int N;
	public static int[][] team;
	public static boolean[] visit;
	public static int MIN = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		team = new int[N][N];
		visit = new boolean[N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < N ; j++) {
				team[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0,0);
		System.out.println(MIN);
	}
	public static void dfs(int start, int depth) {
		if(depth == N/2) {
			diff(); //결과를 나타내는 함수
			return;
		}
		for(int i = start; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				dfs(i+1, depth +1);
				visit[i] = false;
			}
		}
	}
	public static void diff() {
		int start = 0;
		int link = 0;
		for(int i =0; i < N - 1; i++) {
			for(int j = i+1; j < N; j++) {
				if(visit[i] == true && visit[j] == false) {
					start += team[i][j] + team[j][i]; 
				} else if(visit[i] == false && visit[j] == false) {
					link += team[i][j] + team[j][i];
				}
			}
		}
		int val = Math.abs(start - link);
		if(val == 0) {
			System.out.println(val);
			System.exit(0);
		}
		MIN = Math.min(val, MIN);
	}
}
