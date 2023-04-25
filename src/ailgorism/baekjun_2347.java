package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_2347 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] chu = new int[N];
		for(int i = 0 ;i < N; i++) {
			chu[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(chu);
		int answer = 0;
		for(int i = 0; i < N; i++) {
			if(answer+1<chu[i]) break;
			answer += chu[i];
		}
		System.out.println(answer+1);
		
	}
}
