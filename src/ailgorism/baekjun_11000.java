package ailgorism;

import java.util.*;
import java.io.*;

class time implements Comparable<time>{
	int start;
	int end;
	time(int start, int end){
		this.start = start;
		this.end = end;
	}
	public int getStart() {
		return this.start;
	}
	public int getEnd() {
		return this.end;
	}
	
	@Override
	public int compareTo(time t1) {
		return this.getStart() == t1.getStart()?this.getEnd()-t1.getEnd():this.getStart()-t1.getStart();
	}
	
}

public class baekjun_11000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		time[] t = new time[N];
		for(int i =0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = new time(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(t);		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(t[0].getEnd());
		for(int i = 1; i < N; i++) {
			if(pq.peek() <= t[i].getStart()) {
				pq.poll();
			}
			pq.offer(t[i].getEnd());
		}
		System.out.println(pq.size());
	}

}
