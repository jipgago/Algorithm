package ailgorism;

import java.util.Scanner;

public class star {
	static char arr[][];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int Num = sc.nextInt();
		arr = new char[Num][Num];
		
		star(0, 0, Num, false);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < Num; i++) {
			for(int j = 0; j < Num; j++) {
				sb.append(arr[i][j]);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
	static void star(int row, int col, int Num, boolean blank) {
		if(blank) { //공백을 채워주는 조건문
			for (int i = row; i < row + Num; i++) {
				for(int j = col; j < col + Num; j++) {
					arr[row][col] = ' ';
				}
			}
			return;
		}
		if(Num == 1) {// 더이상 쪼개지 못할때
			arr[row][col] = '*';
			return;
		}
		int size = Num / 3;
		int count = 0;
		for(int i = row; i < row + Num; i += size) {
			for(int j = col; j < col + Num; j += size) {
				count++;
				if(count == 5) {
					star(i, j, size, true);
				} else {
					star(i, j, size, false);
				}
			}
		}
	}
}
