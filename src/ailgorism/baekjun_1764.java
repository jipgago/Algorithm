package ailgorism;

import java.io.*;
import java.util.*;

public class baekjun_1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        int donSee = Integer.parseInt(st.nextToken());
        int donLook = Integer.parseInt(st.nextToken());
        
        Map<String, Integer> index = new HashMap<>();
        
        for(int i = 0; i < donSee; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            index.put(key, index.getOrDefault(key, 0) + 1);
        }
        for(int i = 0 ; i < donLook; i++){
            st = new StringTokenizer(br.readLine());
            String key = st.nextToken();
            index.put(key, index.getOrDefault(key, 0) + 1);
        }
        int count = 0;
        for(String name : index.keySet()){
            if(index.get(name) == 2){
                sb.append(name + " ");
                count++;
            }
        }
        String[] name = new String[count];
        
        st = new StringTokenizer(sb.toString());
        for(int i = 0; i < count; i++) {
        	name[i] = st.nextToken();
        }
        Arrays.sort(name);
        sb = new StringBuilder();
        for(int i = 0; i < count; i++) {
        	sb.append(name[i] + "\n");
        }
        System.out.println(count);
        System.out.println(sb.toString());
        

	}

}
