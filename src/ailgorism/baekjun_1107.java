package ailgorism;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class baekjun_1107 {

	static int channel = 100;
	static int targetCh;
	static int N;
	static int brokeNum[];
	static boolean isNum[] = new boolean[10];
	
	
	public static void main(String[] args) throws IOException {
		Arrays.fill(isNum, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		targetCh = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		brokeNum = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			brokeNum[i] = Integer.parseInt(st.nextToken());
			int j = brokeNum[i] - 1 ;
			isNum[j] = false;
		}
		
	}
	public static void bfs(int start, int depth) {
		for(int i = 0; i < N ; i++) {
			
		}
	}

}
