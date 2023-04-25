package ailgorism;

import java.util.*;
import java.io.*;


public class beakjun_13458 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < N; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		long answer = 0;
		for(int i =0; i < N; i++) {
			if(arr[i] <= B) {
				answer++;
				continue;
			} else {
				answer++;
				arr[i] -=B;
				if(arr[i]%C ==0) answer += arr[i]/C;
				else if(arr[i] % C !=0) answer += arr[i]/C + 1;
			}
		}
		System.out.println(answer);
	}

}
