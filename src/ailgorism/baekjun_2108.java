package ailgorism;
import java.util.*;
import java.util.stream.IntStream;
import java.io.*;

public class baekjun_2108 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for(int i = 0 ; i< N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        int middle = arr[N/2];
        
        int min = arr[0];
        int max = arr[arr.length - 1];
        int range = max - min;
        
        int average = (int)Math.round(IntStream.of(arr).sum() / (double) N);
        int mode = mode(arr);
        sb.append(average + "\n").append(middle + "\n").append(mode + "\n")
            .append(range);
        System.out.println(sb.toString());
        
    }
    public static int mode(int[] arr){
        int answer = 0;
        HashMap<Integer, Integer> count = new HashMap<>();
        for(int k : arr){
            count.put(k , count.getOrDefault(k, 0) + 1);
        }
        int max = 0;
        for(Integer n : count.values()){
            max = Math.max(max, n);
        }
        ArrayList<Integer> modeArr = new ArrayList<>();
        int index = 0;
        for(Integer key : count.keySet()){
            if(count.get(key).equals(max)){
                modeArr.add(key);
                index++;
            }
            
        }
        if(index > 1){
            Collections.sort(modeArr);
            answer = modeArr.get(1);
        } else answer = modeArr.get(0);
        return answer;
    }

}
