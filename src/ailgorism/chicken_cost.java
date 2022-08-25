package ailgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class chicken_cost {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int costChick[] = new int[5];
		int cost = 0;
		int entity;
		int price;
		int halfOne;
		
		for(int i = 0; i < costChick.length; i++) {
			costChick[i] = Integer.parseInt(st.nextToken(" "));
		}
		price = costChick[0] + costChick[1];
		halfOne = costChick[2] * 2;
		
		if(price > halfOne) {
			if(costChick[3] < costChick[4]) {
				entity = costChick[4] - costChick[3];
				entity = costChick[4] - entity;
				cost = ((entity * 2) * costChick[2]);
				cost += Math.min(((costChick[4] - costChick[3])*costChick[1]), ((costChick[4] - costChick[3])*halfOne));
				
			} else if (costChick[3] > costChick[4]) {
				entity = costChick[3] - costChick[4];
				entity = costChick[3] - entity;
				cost = ((entity * 2) * costChick[2]);
				cost += Math.min(((costChick[3] - costChick[4])*costChick[0]), ((costChick[3] - costChick[4])*halfOne));
			}
		} else {
			cost = costChick[0] * costChick[3];
			cost += costChick[1] * costChick[4];
		}
		
		System.out.println(cost);
	}

}
