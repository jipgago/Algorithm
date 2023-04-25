package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1260 {
	
	static int N, M, start;
	static boolean[] checked;
	static int[][] check;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		check = new int[1001][1001];
		checked = new boolean[1001];
		
		for(int i =0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			check[x][y] = check[y][x] = 1;
		}
		
		DFS(start);
		sb.append("\n");
		checked = new boolean[1001];
		BFS();
		
		System.out.println(sb.toString());
		
		
	}
	public static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		checked[start] = true;
		sb.append(start).append(" ");
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int j = 1; j <= N; j++) {
				if(check[temp][j] == 1 && checked[j] == false) {
					q.offer(j);
					checked[j] = true;
					sb.append(j).append(" ");
				}
			}
		}
	}
	
	public static void DFS(int i) {
	    checked[i] = true;
	    sb.append(i + " ");
	    
	    for(int j = 1; j <= N; j++) {
	      if(check[i][j] == 1 && checked[j] == false) {
	        DFS(j);
	      }
	    }
	  }
}
