package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1920 {

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] index = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i ++) index[i] = Integer.parseInt(st.nextToken());
        
        int M = Integer.parseInt(br.readLine());
        int[] numbers = new int[M];
        int[] counts = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i < M; i++) numbers[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(index);
        
        for(int a : numbers) {
        	if(Arrays.binarySearch(index, a) >= 0) sb.append(1 + "\n");
        	else sb.append(0 + "\n");
        }
        
        System.out.println(sb.toString());

	}

}
