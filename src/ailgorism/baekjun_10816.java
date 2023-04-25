package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_10816 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> getCard = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int key = Integer.parseInt(st.nextToken());
            getCard.put(key, getCard.getOrDefault(key, 0) + 1);
        }
        
        int[] index = new int[Integer.parseInt(br.readLine())];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < index.length; i++){
            index[i] = Integer.parseInt(st.nextToken());
        }
        for(int c : index){
            String value = String.valueOf(getCard.getOrDefault(c, 0));
            sb.append(value + " ");
        }
        System.out.println(sb);

	}

}
