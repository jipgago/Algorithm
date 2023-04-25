package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1072 {
	private static float X, Y;
	
	//X는 게임횟수, Y는 이긴게임
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		int Z = getPercent(X, Y);
		if(X == Y) {
			System.out.println(-1);
			System.exit(0);
		}
		
		int max = (int) X;
		max++;
		int min = 1;
	
		while(min < max) {
			
			int mid = (max + min) / 2;
			
			
			int percent = getPercent(X + mid, Y + mid);
			
			if(percent <= Z) min = mid + 1;
			else max = mid;
	
		}
		System.out.println(min);
	}
	
	public static int getPercent(float x, float y) {
		return (int) ((y * 100) / x);
	}

}
