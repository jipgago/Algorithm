package ailgorism;

import java.io.*;
import java.util.*;

class Person{
	int weight, height;
	
	Person(int weight, int height){
		this.weight = weight;
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public boolean compareToWH(Person o) {
		return this.getHeight() < o.getHeight() && this.getWeight() < o.getWeight();
	}
	
}

public class baekjun_7586 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Person[] index = new Person[N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			index[i] = new Person(weight, height);
		}
		for(int i = 0; i < N ; i++) {
			int rank = 1;
			
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				if(index[i].compareToWH(index[j])) rank++;
			}
			
			System.out.print(rank + " ");
		}
		
	}
}
