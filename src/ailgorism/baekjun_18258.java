package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_18258 {
	static int read(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = read(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String index = st.nextToken();
			switch(index) {
				case "push":
					q.offer(read(st.nextToken()));
					break;
				case "front":
					if(q.isEmpty())sb.append(-1);
					else sb.append(q.peek());
					break;
				case "empty":
					if(q.isEmpty()) sb.append(1);
					else sb.append(0);
					break;
				case "size":
					sb.append(q.size());
					break;
				case "pop":
					if(q.isEmpty()) sb.append(-1);
					else sb.append(q.poll());
					break;
				case "back":
					if(q.isEmpty()) sb.append(-1);
					else {
						sb.append(q.peekLast());
					}
					break;
			}
		}
		System.out.println(sb.toString());
	}
}
