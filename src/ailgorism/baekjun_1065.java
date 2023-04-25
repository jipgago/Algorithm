package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_1065 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(Solution(N));

	}
	
	public static int Solution(int number) {
		int answer = 0;
		
		if(number < 100) return number;
		else {
			answer = 99;
			for(int i = 100; i <=number; i++) {
				int hund = i / 100;
				int ten = (i / 10) % 10;
				int one = i%10;
				
				if((hund-ten) == (ten - one)) answer++;
			}
		}
		
		return answer;
	}
}
