package ailgorism;

public class programmers_bike_factory {

//	�������� ������ ������ ��Ÿ���� 2���� �迭 cost�� ������ ���� ���� ������
//	��Ÿ���� 2���� �迭 order�� �־����� ��, ����� �����Ÿ� �����ϱ� ���� �ʿ��� 
//	�ּ����� �������� return �ϴ� solution �Լ��� �ϼ��Ͻÿ�.
	
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
		//cost[������ ���۰���][������] order[������][�����ؾ��ϴ� ������]
		int maxMonth = 0;
		for(int[] m : order) maxMonth = Math.max(maxMonth, m[0]); //�����ؾ��ϴ� �ִ� ����
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
