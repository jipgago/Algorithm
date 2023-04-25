package ailgorism;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class baekjun_5585 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int changeMoney = 1000 - Integer.parseInt(br.readLine());
        while(changeMoney > 0){
            if(changeMoney/500 > 0){
                answer += changeMoney / 500;
                changeMoney %= 500;
            } else if(changeMoney / 100 > 0){
                answer += changeMoney / 100;
                changeMoney %= 100;
            } else if(changeMoney / 50 > 0){
                answer += changeMoney / 50;
                changeMoney %= 50;
            } else if(changeMoney / 10 > 0){
                answer += changeMoney / 10;
                changeMoney %= 10;
            } else if(changeMoney / 5 > 0){
                answer += changeMoney/5;
                changeMoney %= 5;
            } else answer += changeMoney;
        }
        System.out.println(answer);

	}

}
