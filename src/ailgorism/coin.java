//package ailgorism;
//
//import java.io.*;
//import java.util.StringTokenizer;
//
//public class coin {
//	public static void main(String[] args) throws IOException {
//		 
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
//		
//		int N = Integer.parseInt(st.nextToken());
//		int K = Integer.parseInt(st.nextToken());
//		
//		int[] coin = new int[N];
//		
//		for(int i = 0; i < N; i++) {
//			coin[i] = Integer.parseInt(br.readLine());
//		}
//		
//		int count = 0;
// 
//		for(int i = N - 1; i >= 0; i--) {
// 
//			// ���� ������ ��ġ�� K���� �۰ų� ���ƾ��� ���������ϴ�.
//			if(coin[i] <= K) {
//				// ���� ��ġ�� �������� ������ �� �ִ� ������ �����ش�.
//				count += (K / coin[i]);
//				K = K % coin[i];
//			}
//		}
//		System.out.println(count);
//	}
//}
