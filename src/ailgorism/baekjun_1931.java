package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1931 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] time = new int[Integer.parseInt(br.readLine())][2];
        for(int i = 0; i < time.length; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken());
            time[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(time, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
            
        });
        
        int count = 0;
        int end_time = 0;
        for(int i = 0; i < time.length; i++) {
        	if(end_time <= time[i][0]){
                end_time = time[i][0];
                count++;
            }
        }
        System.out.println(count);

	}

}
