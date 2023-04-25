package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_2864 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		String[] max = {"", ""};
		String[] min = {"", ""};
		
		String[] num = {st.nextToken(), st.nextToken()};
		
		for(int i = 0 ; i < num[0].length(); i++) {
			if(num[0].charAt(i)=='5' || num[0].charAt(i)=='6') {
				max[0] += "6";
				min[0] += "5";
			} else {
				max[0] += num[0].charAt(i);
				min[0] += num[0].charAt(i);
			}
		}
		for(int i = 0 ; i < num[1].length(); i++) {
			if(num[1].charAt(i)=='5' || num[1].charAt(i)=='6') {
				max[1] += "6";
				min[1] += "5";
			} else {
				max[1] += num[1].charAt(i);
				min[1] += num[1].charAt(i);
			}
		}
		int maximum = Integer.parseInt(max[0]) + Integer.parseInt(max[1]);
		int minimum = Integer.parseInt(min[0]) + Integer.parseInt(min[1]);
		sb.append(minimum + " ").append(maximum);
		System.out.println(sb.toString());
	}

}
