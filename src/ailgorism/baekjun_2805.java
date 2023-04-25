package ailgorism;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class baekjun_2805 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] trees = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
        	trees[i] = Integer.parseInt(st.nextToken());
        }
        
        int min = 0;
        int max = IntStream.of(trees).max().orElse(0);
        while(min < max) {
        	int mid = (min + max) / 2;
        	long sum = 0;
        	for(int t : trees) {
        		if(t - mid > 0) sum += (t-mid);
        	}
        	if(sum < M) max = mid;
    		else min = mid+1;
        }
        System.out.println(min-1);
	}

}
