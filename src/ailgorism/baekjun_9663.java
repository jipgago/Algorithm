package ailgorism;

import java.util.Scanner;

public class baekjun_9663 {
	public static int N;
	public static boolean isused1[], isused2[], isused3[];
	public static int cnt = 0;
	
	static void function(int cur) {
		if(cur == N) {
			cnt++;
			return;
		}
		for(int i = 0; i < N; i++) {
			if(isused1[i] || isused2[i+cur] || isused3[cur - i + N - 1]) {
				continue;
			}
			isused1[i] = true;
			isused2[i+cur] = true;
			isused3[cur - i + N - 1] = true;
			function(1 + cur);
			isused1[i] = false;
			isused2[i+cur] = false;
			isused3[cur - i + N - 1] = false;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.close();
		isused1 = new boolean[N];
		isused2 = new boolean[(N*2)];
		isused3 = new boolean[(N*2)];
		function(0);
		System.out.println(cnt);
	}

}
