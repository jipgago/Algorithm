package ailgorism;

import java.util.*;
import java.io.*;

class Position{
	int x, y;
	Position(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	boolean isVaild(int width, int height) {
		if(this.x < 0 || x >= width) return false;
		if(this.y < 0 || y >= height) return false;
		return true;
	}
	
}

public class baekjun_13460 {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int mapWidth = Integer.parseInt(st.nextToken());
		int mapHeight = Integer.parseInt(st.nextToken());
		
		String[][] maps = new String[mapWidth][mapHeight];
		Position redBall = null, blueBall = null;
		
		
		for(int i = 0; i < mapWidth; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < mapHeight; j++) {
				maps[i][j] = st.nextToken();
				if(maps[i][j].equals("R")) redBall = new Position(i ,j);
				if(maps[i][j].equals("B")) blueBall = new Position(i, j);
			}
		}
		System.out.println(Solution(maps, redBall, blueBall));
		
	}
	
	public static int Solution(String[][] maps, Position RB, Position BB) {
		int answer = 0;
		Queue<Position> q = new LinkedList<>();
		int mapWidth = maps.length;
		int mapHeight = maps[0].length;
		int[][] count = new int[mapWidth][mapHeight];
		boolean[][] visited = new boolean[mapWidth][mapHeight];
		
		q.offer(RB);
		q.offer(BB);
		
		while(!q.isEmpty()) {
			Position currentB = q.poll();
			Position currentR = q.poll();
			
			int currentCount = count[currentR.x][currentR.y];
			final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
			for(int i =0; i < moving.length; i++) {
				Position Rmoved = new Position(currentR.x + moving[i][0], currentR.y + moving[i][1]);
				Position Bmoved = new Position(currentB.x + moving[i][0], currentB.y + moving[i][1]);
				if(!Rmoved.isVaild(mapWidth, mapHeight) || !Bmoved.isVaild(mapWidth, mapHeight)) continue;
//				if(visited[])
			}
		}
		
		return answer;
	}

}
