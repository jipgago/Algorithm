package ailgorism;

public class programmers_broadcast {

	
//	����Ʈ�� ���� N, ���� �������� ��ġ�� ����Ʈ�� ��ȣ�� ��� 1���� �迭 stations, 
//	������ ���� �Ÿ� W�� �Ű������� �־��� ��, ��� ����Ʈ�� ���ĸ� �����ϱ� ���� 
//	�����ؾ� �� ������ ������ �ּڰ��� �����ϴ� solution �Լ��� �ϼ����ּ���
	public static void main(String[] args) {
		int[] a = {4, 11};
		int[] b = {9};
		System.out.println(Solution(11, a, 1));
		System.out.println(Solution(16, b, 2));
		

	}
	public static int Solution(int n, int[] stations, int w) {
		//n�� ����Ʈ ����, stations�� �ʱ����, w�� ����
		int answer = 0;
		int position = 1; //Ȯ���� ����Ʈ ������
		int si = 0; // stations�� �ε��� ��
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
