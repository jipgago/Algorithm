package ailgorism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baekjun_10162 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[3];
        while(T >= 0){
            if(T >= 300){
                arr[0] = T / 300;
                T %= 300;
            } else if( T >= 60){
                arr[1] = T / 60;
                T %= 60;
            } else if(T >= 10){
                arr[2] = T/10;
                T %= 10;
            } else break;
        }
        if(T < 0 || T > 0) System.out.println(-1);
        else System.out.println(arr[0] + " " +arr[1] + " "+arr[2]);
    }
}
