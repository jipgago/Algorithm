package ailgorism;

import java.io.*;
import java.util.StringTokenizer;

public class baekjun_1182 {
	static int N, cnt;
	static int S;
	static int num[], result[];
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(bf.readLine());
		for(int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0,0);
		if(S==0) System.out.println(cnt - 1);
		else System.out.println(cnt);
	}
	public static void dfs(int start, int depth) {
		if(start == N) {
			if(depth == S) {
				cnt++;
			}
			return;
		}
		dfs(start+1, depth+num[start]);
		dfs(start+1, depth);
	}

}
