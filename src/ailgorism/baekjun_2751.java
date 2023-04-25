package ailgorism;
import java.util.*;

public class baekjun_2751 {
	public static int N;
	public static ArrayList<Integer> arr = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		N = sc.nextInt();
		for(int i = 0 ; i < N; i++) {
			arr.add(sc.nextInt());
		}
		sc.close();
		
		Collections.sort(arr);
		
		for(int value : arr) {
			sb.append(value).append('\n');
		}
		System.out.println(sb);
	}

}
