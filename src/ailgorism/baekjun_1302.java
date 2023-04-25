package ailgorism;

import java.util.*;
import java.util.Map.Entry;
import java.io.*;



public class baekjun_1302 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer> arr = new HashMap<>();
		
		
		
		for(int i = 0; i < N; i++) {
			String name = br.readLine();
			arr.put(name, arr.getOrDefault(name, 0) + 1);
		}
		List<Entry<String, Integer>> list_entries = new ArrayList<Entry<String, Integer>>(arr.entrySet());
		Collections.sort(list_entries, new Comparator<Entry<String, Integer>>(){
			public int compare(Entry<String, Integer> obj1, Entry<String, Integer> obj2) {
				// 오름 차순 정렬
				return obj1.getValue()==obj2.getValue()? obj1.getKey().compareTo(obj2.getKey()) : obj2.getValue().compareTo(obj1.getValue());
			}
		});
		
		System.out.println(list_entries.get(0).getKey());
		
	}
}
