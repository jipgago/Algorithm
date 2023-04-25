package ailgorism;


import java.util.PriorityQueue;
import java.util.Collections;

public class programmers_deffense {

	public static int solution(int n, int k, int[] enemy) {
        int my = n;
        int pass = k;
        int answer = enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        if(enemy.length <= k){
            return answer;
        } else{
            for(int i = 0; i < enemy.length; i++){
                my -= enemy[i];
                pq.add(enemy[i]);
                if (my < 0) {
                    if (pass > 0 && !pq.isEmpty()) {
                        my += pq.poll();
                        pass--;
                    } else {
                        answer = i;
                        break;
                    }
                }
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int[] enemy = {5, 5, 4, 3, 2, 5};
		System.out.println(solution(11, 3, enemy));
	}
	
    

}
