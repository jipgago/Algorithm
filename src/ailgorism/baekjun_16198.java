package ailgorism;

import java.util.*;
import java.io.*;


public class baekjun_16198 {
	
	static int N;
	static List<Integer> Weight = new ArrayList<>();
	public static int MAX = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N ; i++) {
			Weight.add(Integer.parseInt(st.nextToken()));
		}
		dfs(N, Weight, 0);
		System.out.println(MAX);
	}
	
	public static void dfs(int n, List<Integer> weight, int sum) {
		if(n == 2) {
			MAX = Math.max(sum, MAX);
			return;
		}
		for(int i = 1; i < weight.size() - 1; i++) {
			int s = weight.get(i-1) * weight.get(i+1);
			int temp = weight.get(i);
			weight.remove(i);
			dfs(n-1, weight, sum+s);
			weight.add(i, temp);
		}
	}
}

