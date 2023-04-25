package ailgorism;

import java.util.*;
import java.io.*;


public class baekjun_2587 {
	static int sum, average, middle;
	static int[] answer = new int[5];
	public static void main(String[] args) throws IOException {
		sum = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i = 0; i < 5; i++) {
			answer[i] = Integer.parseInt(br.readLine());
			sum += answer[i];
		}
		average = sum / 5;
		Arrays.sort(answer);
		middle = answer[2];
		System.out.println(average);
		System.out.println(middle);
	}

}
