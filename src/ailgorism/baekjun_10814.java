package ailgorism;

import java.util.*;
import java.io.*;

public class baekjun_10814 {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            person[i] = new Person(age, name);
        }
        Arrays.sort(person, new Comparator<Person>(){
            
            @Override
            public int compare(Person s1, Person s2){
                return s1.age - s2.age;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < N; i++){
            sb.append(person[i].toString());
        }
        System.out.println(sb);
        
	}

	public static class Person{
	    int age;
	    String name;
	    
	    public Person(int age, String name){
	        this.age = age;
	        this.name = name;
	    }
	    
	    @Override
	    public String toString(){
	        return age + " " + name + "\n";
	    }
	}
}