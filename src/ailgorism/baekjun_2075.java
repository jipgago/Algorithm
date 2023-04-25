package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_2075 {
	//private static int N;
	//private static Integer[] arr;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N*N];
		for(int i =0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[(N*i) + j] = Integer.parseInt(st.nextToken());
			}
			
		}
		sortDesc(arr);
		
		System.out.println(arr[N-1]);
	}
	
	public static void sortAsc(int[] arr) {
        mergeSortAsc(arr, 0, arr.length - 1);
    }

    private static void mergeSortAsc(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortAsc(arr, start, mid);
            mergeSortAsc(arr, mid + 1, end);
            mergeAsc(arr, start, mid, end);
        }
    }

    private static void mergeAsc(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (temp[part1] <= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }
    
    public static void sortDesc(int[] arr) {
        mergeSortDesc(arr, 0, arr.length - 1);
    }

    private static void mergeSortDesc(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSortDesc(arr, start, mid);
            mergeSortDesc(arr, mid + 1, end);
            mergeDesc(arr, start, mid, end);
        }
    }

    private static void mergeDesc(int[] arr, int start, int mid, int end) {
        int[] temp = new int[arr.length];
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1 <= mid && part2 <= end) {
            if (temp[part1] >= temp[part2]) {
                arr[index] = temp[part1];
                part1++;
            } else {
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = temp[part1 + i];
        }
    }
	
}
