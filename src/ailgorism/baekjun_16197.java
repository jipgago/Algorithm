package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_16197 {
	public static int N, M;
	public static boolean isVisited[][][][];
	public static char board[][];
	public static Coin[] coin;
	public static int dx[] = {0, -1, 0, 1};
	public static int dy[] = {-1, 0, 1, 0};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		coin = new Coin[2];
		int coinidx = 0;
		isVisited = new boolean[N][M][N][M];
		board = new char[N][M];
		for(int i = 0 ; i < N ; i++) {
			String a = br.readLine();
			for(int j = 0 ; j < M ; j++) {
				board[i][j] = a.charAt(j);
				if(board[i][j] == 'o') coin[coinidx++] = new Coin(i, j);
			}
		}
		System.out.println(bfs());
		
	}
	public static int bfs() {
		Queue<towCoins> q = new LinkedList<>();
		q.offer(new towCoins(coin[0].x, coin[0].y, coin[1].x, coin[1].y, 0));
		isVisited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;
		
		while(!q.isEmpty()) {
			towCoins current = q.poll();
			if(current.count > 9) break;
			int nx1, nx2, ny1, ny2;
			for(int i = 0; i < 4; i ++) {
				nx1 = current.x1 + dx[i];
				nx2 = current.x2 + dx[i];
				ny1 = current.y1 + dy[i];
				ny2 = current.y2 + dy[i];
				if(!canMoveCoin(nx1, ny1)) {
					nx1 = current.x1;
					ny1 = current.y1;
				}
				if(!canMoveCoin(nx2, ny2)) {
					nx2 = current.x2;
					ny2 = current.y2;
				}
				int flag = 0;
				if(nx1 < N && ny1 < M && nx1 >= 0 && ny1 >= 0) flag++;
				if(nx2 < N && ny2 < M && nx2 >= 0 && ny2 >= 0) flag++;
				if(flag == 1) return current.count+1;
				else if(flag == 2 && !isVisited[nx1][ny1][nx2][ny2]) {
					isVisited[nx1][ny1][nx2][ny2] = true;
					q.offer(new towCoins(nx1, ny1, nx2, ny2, current.count+1));
				}
			}
		}
		
		return -1;
	}
	
	public static boolean canMoveCoin(int x, int y) {
		if(x >=0 && y >= 0 && x < N && y < M && board[x][y] == '#' ) {
			return false;
		}
		return true;
	}
	
	public static class towCoins{ //버튼을 눌렀을 때 동전좌표, 카운트해주는 클래스
		int x1, x2, y1, y2, count;
		public towCoins(int x1, int y1, int x2, int y2, int count) {
			this.count = count;
			this.x1 = x1;
			this.x2 = x2;
			this.y1 = y1;
			this.y2 = y2;
		}
	}
	
	public static class Coin{
		int x;
		int y;
		public Coin(int nx, int ny) {
			this.x = nx;
			this.y = ny;
		}
	}
}

