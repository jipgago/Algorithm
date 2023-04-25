package ailgorism;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class baekjun_2110 {
	static int N, C;
	static int[] home;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		home = new int[N];
		for(int i = 0; i <N; i++) {
			home[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(home);//이분탐색은 반드시 정렬
		
		//upperbound 에서는 min-1을 출력
		int min = 1;
		int max = home[home.length-1]-home[0] + 1;
		
		int mid = 0;
		while(min < max) {
			mid = (min+max) / 2;
			
			if(wifi(mid) < C) max = mid;
			else min = mid+1;
		}
		System.out.println(min-1);
	}
	public static int wifi(int dis) {
		int count = 1;
		int position = home[0];
		for(int i = 1; i < N; i++) {
			int nowPosition = home[i];
			
			if(nowPosition - position >= dis) {
				count++;
				position = nowPosition;
			}
			
		}
		
		return count;
	}

}
