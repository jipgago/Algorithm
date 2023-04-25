package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_1541 {

	public static void main(String[] args) throws IOException {
		int answer = Integer.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
        while(sub.hasMoreTokens()){
            int temp = 0;
            
            StringTokenizer sum = new StringTokenizer(sub.nextToken(), "+");
            while(sum.hasMoreTokens()){
                temp += Integer.parseInt(sum.nextToken());
            }
            if(answer == Integer.MAX_VALUE) answer = temp;
            else answer -= temp;
            
        }
        System.out.println(answer);

	}

}
