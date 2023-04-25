package ailgorism;

public class progrmmers_prime_number {

	public static void main(String[] args) {
		System.out.println(solution(5));

	}

	public static int solution(int n) {
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			answer += prime_number(i);
		}
		return answer;
	}

	public static int prime_number(int number) {
		// 0 �� 1 �� �Ҽ��� �ƴϹǷ� ����
		if (number < 2) {
			return 0;
		}

		// 2 �� �Ҽ���
		if (number == 2) {
			return 1;
		}

		for (int i = 2; i <= Math.sqrt(number); i++) {
			// �Ҽ��� �ƴҰ�� ����
			if (number % i == 0) {
				return 0;
			}
		}
		return 1;
	}
}
