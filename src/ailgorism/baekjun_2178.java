package ailgorism;

import java.util.*;



import java.io.*;

class Positions {
	int x, y;
	
	Positions(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	boolean isValid(int width, int height){
        if(x < 0 || x >= width) return false;
        if(y < 0 || y >= height) return false;
        return true;
    }
	
}

public class baekjun_2178 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int height = Integer.parseInt(st.nextToken());
		int width = Integer.parseInt(st.nextToken());
		
		int[][] maps = new int[height][width];
		
		for(int i = 0; i < height; i++) {
			String num = br.readLine();
			for(int j = 0; j < width; j++) {
				int nums =  Character.getNumericValue(num.charAt(j));
				maps[i][j] = nums;
			}
		}
		int answer = Solution(maps);
		System.out.println(answer);
	}
	public static int Solution(int[][] map) {
		Queue<Positions> q = new LinkedList<>(); 
		int mapHeight = map.length;
		int mapWidth = map[0].length;
		int[][] count = new int[mapHeight][mapWidth];
		boolean[][] isVisited = new boolean[mapHeight][mapWidth];
		
		q.offer(new Positions(0, 0));
		count[0][0] = 1;
		isVisited[0][0] = true;
		
		while(!q.isEmpty()) {
			Positions current = q.poll();
			
			int currentCount = count[current.y][current.x];
			
			final int[][] moving = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
			for(int i = 0; i < moving.length; i++) {
				Positions moved = new Positions(current.x + moving[i][0], current.y + moving[i][1]);
				if(!moved.isValid(mapWidth, mapHeight)) continue;
				if(isVisited[moved.y][moved.x]) continue;
				if(map[moved.y][moved.x] == 0) continue;
				count[moved.y][moved.x] = currentCount + 1;
				isVisited[moved.y][moved.x] = true;
				q.offer(moved);				
			}
		}
		
		int answer = count[mapHeight-1][mapWidth -1];
		
		if(answer == 0) return -1;
		
		return answer;
	}

}
