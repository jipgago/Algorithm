package ailgorism;

import java.util.Scanner;

public class basic_algorithm {
	static String s;
	static int isused[] = new int[26];
	public static void function(String a) {
		for(int i = 0; i < a.length(); i++) {
			int q = a.charAt(i)-97;
			isused[q]++;
		}
		for(int i = 0; i < isused.length; i++) {
			System.out.print(isused[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		sc.close();
		function(s);
	}

}
