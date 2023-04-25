package ailgorism;

import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class baekjun_1049 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] bundle = new int[M];
        int[] single = new int[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            bundle[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }
        int bundleMin = IntStream.of(bundle).min().orElse(0);
        int singleMin = IntStream.of(single).min().orElse(0);
        int answer = 0;
        while(N > 0){
            if(N <= 6){ 
                answer += Math.min(bundleMin, singleMin * N);
                break;
            }
            else{
                answer += Math.min(bundleMin, singleMin * 6);
                N -= 6;
            }

        }
        System.out.println(answer);
	}

}
