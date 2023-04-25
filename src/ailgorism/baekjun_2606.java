package ailgorism;

import java.util.*;
import java.io.*;

class ArrGraph{
	int[][] graph;
	boolean[] isChecked;
	int a;
	
	ArrGraph(int init){
		this.a = init;
		this.graph = new int[init+1][init+1];
		this.isChecked = new boolean[init+1];
	}
	public void initChecked() {
		this.isChecked = new boolean[a];
	}
	
	public void put(int x, int y) {
		this.graph[x][y] = this.graph[y][x] = 1;
	}
	
	public void print() {
		StringBuilder sb = new StringBuilder();
		
	    for(int i=0; i<graph.length; i++) {
	    	sb.append("\n");
	        for(int j=0; j<graph[i].length; j++) {
	        	sb.append(graph[i][j]).append(" ");
	        }
	    }
		System.out.println(sb.toString());
	}
	
	public boolean bfsCheck(int temp, int j) {
		return this.graph[temp][j] == 1 && this.isChecked[j] == false;
	}
}

public class baekjun_2606 {
	static int dfsAnswer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		ArrGraph node = new ArrGraph(N);
		
		for(int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int key = Integer.parseInt(st.nextToken());
			int connect = Integer.parseInt(st.nextToken());
			node.put(key, connect);
		}
//		node.print();
		BFS(node);
		//node.initChecked();
		//DFS(node, 1);
		//System.out.println(dfsAnswer - 1);
	}
	
	public static void BFS(ArrGraph node) {
		StringBuilder sb = new StringBuilder();
		Queue<Integer> q = new LinkedList<>();
		int answer = 0;
		q.offer(1);
		node.isChecked[1] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int j = 1; j < node.graph.length; j++) {
				if(node.bfsCheck(temp, j)) {
					q.offer(j);
					node.isChecked[j] = true;
					answer++;
				}
			}
		}
		System.out.println(answer);
	}
	
	public static void DFS(ArrGraph node, int start) {
		
		node.isChecked[start] = true;
		dfsAnswer++;
		
		for(int i = 1 ; i < node.graph.length ; i++) {
			if(node.graph[start][i] == 1 && !node.isChecked[i])
				DFS(node, i);
		}
	}

}
