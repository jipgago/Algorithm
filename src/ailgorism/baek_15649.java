package ailgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baek_15649 {
	static int N, M;
	static int arr[] = new int[10];
	static boolean isused[] = new boolean[10];

	public static void back(int k) {
		if(k == M) {
			for(int i = 0; i < M; i++){
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for(int i = 1; i <= N; i++) {
			if(!isused[i]) {
				arr[k] = i;
				isused[i] = true;
				back(k+1);
				isused[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		N = Integer.parseInt(st.nextToken(" "));
		M = Integer.parseInt(st.nextToken(" "));
		back(0);
	}
}
