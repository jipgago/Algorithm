package ailgorism;
import java.util.Scanner;


public class baekjun_25640 {
	
	private static String me;
	private static String[] them;
	private static int they;
	public static int answer =0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		me = sc.nextLine();
		they = sc.nextInt();
		them = new String[they];
		for(int i = 0 ; i < they; i++) {
			them[i] = sc.nextLine();
			if(them[i].equals("")) i--;
			else if(me.equals(them[i])) {
				answer+=1;
			}
			
		}
		
		System.out.println(answer);
	}

}
