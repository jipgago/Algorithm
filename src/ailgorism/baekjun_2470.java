package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_2470 {
	static int read(String s) {return Integer.parseInt(s);}
	
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = read(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N; i++) {
			arr[i] = read(st.nextToken());
		}
		Arrays.sort(arr);
		
		int min = 0;
		int max = arr.length-1;
		
		int gap = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		
		int temp;
		int sum;
		
		while(min < max) {
			sum = arr[min] + arr[max];
			temp = Math.abs(sum);
			if(temp < gap) {
				gap = temp;
				ans1 = arr[min];
				ans2 = arr[max];
			}
			if(sum > 0) max--;
			else min++;
		}
		System.out.println(ans1 + " " + ans2);
	}

}
