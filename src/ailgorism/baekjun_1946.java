package ailgorism;

import java.util.*;
import java.io.*;

class Grade implements Comparable<Grade>{
	int a;
	int b;
	Grade(int a, int b){
		this.a = a;
		this.b = b;
	}
	
    @Override
    public int compareTo(Grade o){
        if(this.a > o.a) return 1;
        else return -1;
    }
}

public class baekjun_1946 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();
            for(int j = 0; j < N; j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list.add(new Grade(a, b));
            }
            Collections.sort(list);
            
            int answer = 1;
            int min = list.get(0).b;
            for(int n = 1; n < N; n++){
                if(min > list.get(n).b){
                    answer++;
                    min = list.get(n).b;
                }
            }
            System.out.println(answer);
        }
    }

}
