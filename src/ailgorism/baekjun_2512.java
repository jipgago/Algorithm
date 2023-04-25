package ailgorism;

import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class baekjun_2512 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] index = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =0; i < N; i ++) {
			index[i] = Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		
		
		System.out.println(Solution(index, M));
	}
	public static int Solution(int[] budget, int M) {
		int answer = 0;
		int min = 0;
		int max = IntStream.of(budget).max().orElse(0);
		
		while(min <= max) {
			final int mid = (min+max)/2;
			int sum = IntStream.of(budget).map(b->Math.min(b, mid)).sum();
			
			if(sum <= M) {
				min = mid+1;
				answer = mid;
			} else max = mid - 1;
		}
		
		
		return answer;
	}

}
