package ailgorism;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class baekjun_13305 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] cityFuel = new int[N];
		int[] dist = new int[N-1];
		int answer = 0;
		int mincost = 0;
		st = new StringTokenizer(br.readLine());
		for(int i =0; i < N-1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			cityFuel[i] = Integer.parseInt(st.nextToken());
		}
		
		if(IntStream.of(cityFuel).sum() == N) {
			mincost = IntStream.of(dist).sum();
			System.out.println(mincost);
			System.exit(0);
		}
		mincost = cityFuel[0];
		answer = mincost*dist[0];
		for(int i = 1; i < N-1; i++) {
			if(mincost > cityFuel[i]) mincost = cityFuel[i];
			answer += mincost * dist[i];
		}
		System.out.println(answer);
		
	}

}
