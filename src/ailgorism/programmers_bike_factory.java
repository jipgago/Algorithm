package ailgorism;

public class programmers_bike_factory {

//	전기요금의 누진제 정보를 나타내는 2차원 배열 cost와 자전거 생산 예약 정보를
//	나타내는 2차원 배열 order가 주어졌을 때, 명수가 자전거를 생산하기 위해 필요한 
//	최소한의 전기요금을 return 하는 solution 함수를 완성하시오.
	
	public static void main(String[] args) {
		int[][] cost1 = {{0,10},{50,20},{100,30},{200,40}};
		int[][] order1 = {{3,50},{7,200},{8,200}};
		int[][] cost2 = {{0,10},{50,20}};
		int[][] order2 = {{3,100},{4,200}};
		
		System.out.println(solution(cost1, order1));
		System.out.println(solution(cost2, order2));

	}
	public static int solution(int[][] cost, int[][] order) {
		int answer = 0;
		//cost[자전거 시작갯수][누진세] order[개월수][납부해야하는 자전거]
		int maxMonth = 0;
		for(int[] m : order) maxMonth = Math.max(maxMonth, m[0]); //생산해야하는 최대 개월
		int[] monthlyOrder = new int[maxMonth];
		int need = 0;
		int made = 0;
		for(int[] n : order) {
			monthlyOrder[n[0] - 1] = n[1];
			need += n[1];
		}
		for(int i =0; i < cost.length-1; i++) {
			if(need == 0 || made >= need) break;
			int price = cost[i][1];
			int limit = cost[i+1][0] - cost[i][0];
			int rest = 0;
			
			for(int j = 0; j < maxMonth;j++) {
				if(need == 0 || made >= need) break;
				int making = Math.min(limit, need - made);
				answer += price * making;
				made += making;
				need -= monthlyOrder[j];
				if(monthlyOrder[j] == 0) continue;
				int delivery = Math.min(made, monthlyOrder[j]);
				
				made -= delivery;
				monthlyOrder[j] -= delivery;
				rest += monthlyOrder[j];
			}
			need = rest;
			made = 0;
		}
		answer += need*cost[cost.length - 1][1];
		return answer;
    }
}
