package ailgorism;

import java.util.*;

public class car_num {
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static char[][] board;
    static Coin[] coin; // ������ ��ġ ����. 
    static boolean[][][][] visited;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        n = scan.nextInt();
        m = scan.nextInt();
 
        board = new char[n][m];
        coin = new Coin[2];
        int coinIdx = 0;
        for(int i = 0; i < n; i++) {
            String str = scan.next();
            for(int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if(c == 'o') {
                    coin[coinIdx++] = new Coin(i, j); //������ ��ġ ���� 
                }
                board[i][j] = c;
            }
        }
 
        visited = new boolean[n][m][n][m]; //[ù��°������x��ġ][ù��°������y��ġ][�ι�°������x��ġ][�ι�°������y��ġ]
        System.out.println(bfs());
    }
 
    public static int bfs() {
        Queue<towCoins> q = new LinkedList<>();
        q.offer(new towCoins(coin[0].x, coin[0].y, coin[1].x, coin[1].y, 0));
        visited[coin[0].x][coin[0].y][coin[1].x][coin[1].y] = true;
 
        while(!q.isEmpty()) {
            towCoins current = q.poll();
            
            if(current.count >= 10) break;
            
 
            for(int i = 0; i < 4; i++) {
//            	System.out.println(current.count);
                int nx1 = current.x1 + dx[i];
                int ny1 = current.y1 + dy[i];
                int nx2 = current.x2 + dx[i];
                int ny2 = current.y2 + dy[i];
                
                //�̵��� ��ǥ�� ���̸� �̵��� �� �����Ƿ� �̵����� �ʴ´�.
                if(!canMoveCoin(nx1, ny1)) { 
                    nx1 = current.x1;
                    ny1 = current.y1;
                }
                if(!canMoveCoin(nx2, ny2)) {
                    nx2 = current.x2;
                    ny2 = current.y2;
                }
 
                int flag = 0; //�������� �ʴ� ������ ����
                if(nx1 >= 0 && ny1 >= 0 && nx1 < n && ny1 < m) flag++;
                if(nx2 >= 0 && ny2 >= 0 && nx2 < n && ny2 < m) flag++;
 
                if(flag == 1) return current.count + 1;
                else if(flag == 2 && !visited[nx1][ny1][nx2][ny2]) {
                    visited[nx1][ny1][nx2][ny2] = true;
                    q.offer(new towCoins(nx1, ny1, nx2, ny2, current.count + 1));
                }
            }
        }
        return -1;
    }
 
    public static boolean canMoveCoin(int nx, int ny) {
        if(nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == '#') {
            return false;
        }
        return true;
    }
 
    public static class towCoins { //�� ������ ��ġ�� ���� ��ư�� ���� Ƚ���� ����ϴ� ��ü
        int x1;
        int y1;
        int x2; 
        int y2;
        int count;
 
        public towCoins(int x1, int y1, int x2, int y2, int count) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
            this.count = count;
        }
    }
 
    public static class Coin { //������ ��ǥ�� ����ϴ� ��ü
        int x;
        int y;
 
        public Coin(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
