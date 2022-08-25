package ailgorism;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class baekjun_6603 {

	static boolean isused1[] = new boolean[49];
	static int[] S;
	static int k;
	static int[] result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			k = Integer.parseInt(st.nextToken(" "));
			if(k == 0) {
				break;
			}
			result = new int[k];
			S = new int[k];
			for(int i = 0; i < k; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			dfs(0,0);
			System.out.println();
		}
	}
	
	public static void dfs(int start, int depth) {
		if(depth == 6) print();
		for(int i = start; i < k; i++) {
			result[i] = 1;
			dfs(i+1, depth + 1);
			result[i] = 0;
		}
	}
	
	public static void print() {
		for(int i=0; i < k; i++) {
			if(result[i] == 1) {
				System.out.print(S[i] + " ");
			}
		}
		System.out.println();
	}
}
