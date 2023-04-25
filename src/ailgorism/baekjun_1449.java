package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1449 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int answer = 0;
		answer = Solution(N ,arr, L);
		
		System.out.println(answer);
	}
	
	public static int Solution(int n , int[] arr, int tape) {
		int w = (int)(arr[0] - 0.5 + tape);
		int answer = 1;
		for(int i = 1; i < arr.length; i++) {
			if (w < (int)(arr[i] + 0.5)){
				w = (int)(arr[i] - 0.5 + tape);
				answer++;
			}
		}
		
		
		return answer;
	}

}
