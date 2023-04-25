package ailgorism;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class baekjun_1654 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[] lan = new int[K];
		
		for(int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
		}
		
		int max = IntStream.of(lan).max().orElse(0);
		max++;
		
		int min = 0;
		while(min < max) {
			int mid = (max+min)/2;
			int sum = 0;
			for(int l : lan) {
				sum += (l/mid);
			}
			if(sum < N) max = mid;
			else min = mid+1;
		}
		System.out.println(min-1);
	}
}
