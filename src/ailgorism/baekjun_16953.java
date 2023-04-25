package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int answer = 1;
        
        while(A != B){
            if(A > B) {
                answer = -1;
                break;
            }
            String b = Integer.toString(B);
            if(b.charAt(b.length()-1) != '1' && B % 2 != 0){
                answer = -1;
                break;
            }
            if(b.charAt(b.length()-1) == '1'){ 
                b = b.substring(0, b.length()-1);
                B = Integer.parseInt(b);
                answer++;
                continue;
            }
            B /= 2;
            answer++;
        }
        System.out.println(answer);

	}

}
