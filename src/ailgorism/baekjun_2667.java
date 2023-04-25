package ailgorism;

import java.util.*;
import java.io.*;


public class baekjun_2667 {
	private static int[][] arr;
	private static boolean[][] visit;
	final static int[][] moved = {{0, 1},{0, -1},{1, 0},{-1, 0}};
	private static int count = 0, number = 0;
	private static int curX, curY, N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		List<Integer> list = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visit = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			String num = br.readLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = num.charAt(j) - '0';
			}
		}
		//여기까지가 입력
		for(int i =0; i<N; i++) {
			for(int j = 0; j < N; j++) {
				//방문을 안했을 시 와 단지가 형성되어 있을 때 순회함
				if(visit[i][j] == false && arr[i][j] ==1) {
					count = 0;
					number++;
					DFS(i, j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		sb.append(number+"\n");
		for(int num : list) sb.append(num + "\n");
		System.out.println(sb.toString());
	}
	
	public static void DFS(int x, int y) {
		visit[x][y] = true;
		arr[x][y] = number;
		count++;
		
		for(int i =0; i < moved.length; i++) {
			curX = moved[i][0] + x;
			curY = moved[i][1] + y;
			if(isValid() && visit[curX][curY] == false && arr[curX][curY] == 1) {
				visit[curX][curY] = true;
				arr[curX][curY] = number;
				
				DFS(curX, curY);
			}
		}
	}
	
	public static boolean isValid() {
		return (curX >= 0 && curY < N && curY >= 0 && curX < N);
	}
}
