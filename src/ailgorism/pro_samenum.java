package ailgorism;

import java.util.*;
import java.util.stream.IntStream;


public class pro_samenum {

	public static void main(String[] args) {
		int[] arr = {1, 1, 2, 3, 4, 5};
		int[] arr2 = {0, 2, 3, 4};
		
		System.out.println(solution(arr, 1));
		System.out.println(solution(arr2, 1));
		
	}
	
    public static int solution(int[] array, int n) {
        int answer = 0;
        Arrays.sort(array);
        int index = Arrays.binarySearch(array, n);
        if(index < 0) return 0;
        else{
            for(int i = index; i < array.length; i++){
                if(array[i] != n) break;
                answer++;
            }
        }
        return answer;
    }

}
