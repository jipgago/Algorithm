package ailgorism;

import java.io.*;
import java.util.StringTokenizer;

public class baekjun_5637 {

	public static void main(String[] args) throws IOException {
		String answer = "";
		int max = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String  tmp = "";
			StringTokenizer st = new StringTokenizer(br.readLine(), " .,()", false);
			while(st.hasMoreTokens()) {
				tmp = st.nextToken();
				if(tmp.equals("E-N-D")) break;
				if(max < tmp.length()) {
					max = tmp.length();
					answer = tmp;
				}
				
			}
			if(tmp.equals("E-N-D")) break;
		}
		System.out.println(answer.toLowerCase());
	}

}
