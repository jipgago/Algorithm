package ailgorism;

import java.util.*;
import java.io.*;

class Jewely {
    int weight;
    int price;
    Jewely(int weight, int price){
        this.weight = weight;
        this.price = price;
    }
//    @Override
//    public int compareTo(Jewely o){
//        if(this.price > o.price) return -1;
//        else if(this.price == o.price) return this.weight - o.weight;
//        else return 1;
//    }
    
    public void print() {
    	System.out.println( "(" + this.weight + ", " + this.price + ")");
    }
}

public class baekjun_1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int bagMass[] = new int[K];
        Jewely[] list = new Jewely[N];
//        PriorityQueue<Jewely> list = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list[i] = new Jewely(w, p);
        }
        Arrays.sort(list, new Comparator<Jewely>() {
        	@Override
        	public int compare(Jewely a, Jewely b) {
        		return a.weight == b.weight ? b.price - a.price : a.weight - b.weight;
        	}
        });

        for(int i = 0; i < K ; i ++) {
        	bagMass[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bagMass);
        int answer = 0;
        int index = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i = 0, j=0; i < K ; i++) {
        	while(j < N && list[j].weight <= bagMass[i]) {
        		pq.offer(list[j++].price);
        	}
        	if(!pq.isEmpty()) {
        		answer += pq.poll();
        	}
        }
        
//        while(!list.isEmpty()) {
//        	if(bagMass.length - 1 < index) break;
//        	Jewely o = list.poll(); 
//        	if(o.weight <= bagMass[index]) {
//        		bagMass[index] -= o.weight;
//        		answer += o.price;
//        		index++;
//        		continue;
//        	} else {
//        		continue;
//        	}
//        }
        System.out.println(answer);
	}

//	3 2
//	1 65
//	5 23
//	2 99
//	10
//	2
	
}
