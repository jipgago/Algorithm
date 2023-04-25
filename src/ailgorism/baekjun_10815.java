package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_10815 {
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] index = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			index[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		int[] card = new int[M];
		int[] had = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i ++) {
			card[i] = Integer.parseInt(st.nextToken());
			had[i] = 0;
		}
		Arrays.sort(index);
		for(int i = 0; i < M ; i++) {
			//System.out.println(Arrays.binarySearch(index, card[i]));
			if(Arrays.binarySearch(index, card[i]) >= 0 ) {
				
				had[i] = 1;
			}
			sb.append(had[i]+" ");
		}
		
		System.out.println(sb.toString());
	}

}
