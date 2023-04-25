package ailgorism;

import java.util.stream.*;

public class programmers_incentive {

	public static void main(String[] args) {
		int[] a = {120,110,140,150};
		System.out.println(solution(a, 485));

	}
	public static int solution(int[] budgets, int M) {
        int answer = 0;
        int min = IntStream.of(budgets).min().orElse(0);
        int max = IntStream.of(budgets).max().orElse(0);
        int mid = Integer.MAX_VALUE;
        while(min < max){
            mid = (min + max) / 2;
            int count = 0;
            for(int a : budgets){
                if(a > mid){
                    count += mid;
                } else count += a;
            }
            if(count >= M){
                max = mid;
            } else {
            	min = mid;
            }
            if(max == min+1 && mid==min ) {
            	answer = mid;
            	break;
            }

        }
        
        return answer;
    }
}
