package ailgorism;

import java.io.*;


public class baekjun_14916 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int money = Integer.parseInt(br.readLine());
		int answer = 0;
		while(money > 0) {
			if(money % 5 == 0) {
				answer += money / 5;
				break;
			}
			money -= 2;
			answer++;
		}
		System.out.println(answer);
	}

}
