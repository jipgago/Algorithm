package ailgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

public class baekjun_2217 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        int[] rope = new int[N];
        for(int i = 0;i < N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);
        for(int i = N-1; i >=0; i--) {
        	rope[i] *=  (N-i);
        	if(answer < rope[i]) answer = rope[i];
        }
        System.out.println(answer);
	}

}
