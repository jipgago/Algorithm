package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1744 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		if(N == 1) {
			System.out.println(br.readLine());
			System.exit(0);
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> mq = new PriorityQueue<>();
		
		for(int i = 0 ; i < N; i++) {
			int number = Integer.parseInt(br.readLine());
			
			if(number <= 0) mq.offer(number);
			else pq.offer(number);
		}
		
		int answer = 0;
		while(!pq.isEmpty()) {
			if(pq.size()==1) {
				answer += pq.poll();
				break;
			}
			int num = pq.poll();
			int num2 = pq.poll();
			answer += Math.max(num+num2, num * num2);
		}
		while(!mq.isEmpty()) {
			if(mq.size()==1) {
				answer += mq.poll();
				break;
			}
			int num = mq.poll();
			int num2 = mq.poll();
			answer += Math.max(num + num2 , num * num2);
		}
		
		System.out.println(answer);
	}

}
