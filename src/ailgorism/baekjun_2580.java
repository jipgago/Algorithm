package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_2580 {

	public static int[][] sudoku = new int[9][9];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 9; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0 ; j < 9 ; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
	}
	
	public static void dfs (int start, int depth) {

		if(depth == 9) {
			dfs(start + 1, 0);
			return;
		}
		
		if(start == 9) {
			print();
			System.exit(0); //이거 안써주면 오류
		}
		
		if(sudoku[start][depth] == 0) {
			for(int n = 1; n <= 9; n++) {
				if(possible(start, depth, n)) {
					sudoku[start][depth] = n;
					dfs(start, depth+1);
				}
			}
			sudoku[start][depth] = 0;
			return;
		}

		dfs(start, depth + 1);
	}
	
	public static void print() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 9; i++) {
			for(int j = 0 ; j < 9; j++) {
				sb.append(sudoku[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	public static boolean possible(int row, int col, int value) {
		
		for(int i = 0; i < 9; i++) {
			if(sudoku[row][i] == value) {
				return false;
			}
		}
		
		for(int i = 0; i < 9; i++) {
			if(sudoku[i][col] == value) {
				return false;
			}
		}
		
		int searchRow = (row / 3) * 3;
		int searchCol = (col / 3) * 3;
		
		for(int i = searchRow; i < searchRow + 3; i++) { //3x3 검사
			for(int j = searchCol ; j < searchCol + 3; j++) {
				if(sudoku[i][j] == value) {
					return false;
				}
			}
		}
		
		return true;
	}

}
