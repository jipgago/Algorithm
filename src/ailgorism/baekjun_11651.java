package ailgorism;

import java.util.*;
import java.io.*;

class Coordinate implements Comparable<Coordinate>{
	int x;
	int y;
	
	Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}

	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public String print() {
		return (this.getX() + " " + this.getY());
	}
	
	
	@Override
	public int compareTo(Coordinate a) {
		return this.getY() == a.getY() ? this.getX()-a.getX():this.getY()-a.getY();
	}
	
	
}

public class baekjun_11651 {
	


	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Coordinate[] arr = new Coordinate[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Coordinate(x, y);
		}
		Arrays.sort(arr);
		
		for(int i = 0; i < N ; i++) {
			sb.append(arr[i].print() + "\n");
		}
		System.out.println(sb.toString());
	}

}
