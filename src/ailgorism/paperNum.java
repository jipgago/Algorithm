package ailgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class paperNum{
	public static int matrix[][];
	public static int plus = 0;
	public static int zero = 0;
	public static int minus = 0;
	
	public static void main(String[] args)  throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int size = Integer.parseInt(st.nextToken());
		matrix = new int[size][size];
		for (int i = 0; i < size ; i++) {
			StringTokenizer se = new StringTokenizer(br.readLine(), " "); //���� ���������� ��������ؼ� �ݺ����� ����־�� �Ѵ�.
			for(int j = 0 ; j < size; j++) {
				matrix[i][j] = Integer.parseInt(se.nextToken());
			}
		}
		partition(0, 0, size);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(plus);
		
	}
	
	public static void partition(int row, int col, int size) {
		if(numCheck(row, col, size)) {
			if(matrix[row][col] == -1) {
				minus++;
			} else if(matrix[row][col] == 0) {
				zero++;
			} else {
				plus++;
			}
			return;
		}
		//9x9 , 3x3, 1x1 ������ �˻�
		int newSize = size / 3;
		
		partition(row, col, newSize); 								// ���� ��
		partition(row, col + newSize, newSize); 					// �߾� ��
		partition(row, col + 2 * newSize, newSize);					// ������ ��
		
		partition(row + newSize, col, newSize);						// ���� �߰�
		partition(row + newSize, col + newSize, newSize);			// �߾� �߰�
		partition(row + newSize, col + 2 * newSize, newSize);		// ������ �߰�
		
		partition(row + 2 * newSize, col, newSize);					// ���� �Ʒ�
		partition(row + 2 * newSize, col + newSize, newSize);		// �߾� �Ʒ�
		partition(row + 2 * newSize, col + 2 * newSize, newSize);
		
		
	}
	
	public static boolean numCheck(int row, int col, int size) {
		int number = matrix[row][col];
		// �迭�� ���������� �迭�� ������ �˻�
		for(int i = row; i < row + size; i++) { 
			for(int j = col; j < col + size; j++) {
				if(number != matrix[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
	
}
