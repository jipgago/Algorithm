package ailgorism;

public class programmers_broadcast {

	
//	아파트의 개수 N, 현재 기지국이 설치된 아파트의 번호가 담긴 1차원 배열 stations, 
//	전파의 도달 거리 W가 매개변수로 주어질 때, 모든 아파트에 전파를 전달하기 위해 
//	증설해야 할 기지국 개수의 최솟값을 리턴하는 solution 함수를 완성해주세요
	public static void main(String[] args) {
		int[] a = {4, 11};
		int[] b = {9};
		System.out.println(Solution(11, a, 1));
		System.out.println(Solution(16, b, 2));
		

	}
	public static int Solution(int n, int[] stations, int w) {
		//n은 아파트 갯수, stations는 초기기지, w는 범위
		int answer = 0;
		int position = 1; //확인할 아파트 포지션
		int si = 0; // stations의 인덱스 값
		while(position <= n) {
			if(si < stations.length && stations[si] - w <= position) {
				position = stations[si] + w + 1;
				si++;
			} else {
				answer++;
				position += w*2+1;
			}
		}
		
		return answer;
	}

}
