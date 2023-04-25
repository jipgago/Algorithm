package ailgorism;

import java.util.*;
import java.util.stream.IntStream;

//class Member{
//	int visited = -1;
//	int groupNumber = -1;
//
//}

//class ListMap{
//    private Map<String, List<String>> map = new HashMap<>();
//
//    List<String> get(String key){
//        if(!map.containsKey(key)) {
//            map.put(key, new ArrayList<>());
//        }
//        return map.get(key);
//    }
//
//    void append(String key, String value){
//        get(key).add(value);
//    }
//
//}
//
//class CountMap{
//    private Map<String, Integer> map = new HashMap<>();
//
//    Integer get(String key) {
//        if(!map.containsKey(key)) map.put(key, 0);
//        return map.get(key);
//    }
//    void add(String key, Integer value){
//        map.put(key, get(key) + value);
//    }
//}

public class programmers_test {
    public static int[][] answer;

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String[] s1 = {"left", "right", "up", "right", "right"};
		String[] s2 = {"down", "down", "down", "down", "down"};
		int[] b1 = {11, 11};
		int[] b2 = {7, 9};
		int[] answer = solution(s1, b1);
		int[] answer2 = solution(s2, b2);
		for(int i = 0 ; i < 2; i++) {
			System.out.println(answer[i]);
			System.out.println(answer2[i]);
		}

		
//		int[] coin = {0,1,1,0,1,1};
//		int[] coin2 = {1,0,1};
//		int[] coin3 = {0,0,1,1,0,0};
//		
//		System.out.println(solution(coin, 3));
//		System.out.println(solution(coin2, 3));
//		System.out.println(solution(coin3, 2));

	}
	
    public static int[] solution(String[] keyinput, int[] board) {
        int upMax = board[1] / 2 + 1;
        int rightMax = board[0] / 2 + 1;
        int[] answer = {0, 0};
        for(String w : keyinput){
            switch(w){
                case "left":{
                    if(answer[0] == (rightMax * (-1))) break;
                    else answer[0] -= 1;
                    break;
                }
                case "right":{
                    if(answer[0] == rightMax) break;
                    else answer[0] += 1;
                    break;
                }
                case "up":{
                    if(answer[1] == upMax) break;
                    else answer[1] += 1;
                    break;
                } case "down":{
                    if(answer[1] == upMax * -1) break;
                    else answer[1] -= 1;
                    break;
                }
            }
        }
        return answer;
    }
	
//	public static String[] solution(String[] s1, String[] s2, String k) {
//        List<String> answer = new ArrayList<>();
//
//        ListMap graph = new ListMap();
//        for(int i = 0 ; i< s1.length; i++){
//            graph.get(s2[i]).add(s1[i]); // 강의 - > 선수강의
//        }
//        Queue<String> queue = new PriorityQueue<>();
//        ListMap graphK = new ListMap();
//        CountMap indegreed = new CountMap(); //강의 : 진입차수
//
//        //DFS 방식으로 생성
//        Stack<String> stack = new Stack<>();
//        Set<String> visited = new HashSet<>();
//        stack.push(k);
//        visited.add(k);
//
//        while(!stack.isEmpty()){
//            String node = stack.pop();
//
//            if(graph.get(node).isEmpty()){
//                queue.offer(node);
//                continue;
//            }
//
//            for(String prev : graph.get(node)){
//                indegreed.add(node, 1);
//                graphK.append(prev, node);
//                if(visited.contains(prev)) continue;
//                stack.push(prev);
//                visited.add(prev);
//            }
//        }
//        
//        while(!queue.isEmpty()){
//            String node = queue.poll();
//            answer.add(node);
//            for(String next : graphK.get(node)){
//                indegreed.add(next, -1);
//                if(indegreed.get(next) == 0) queue.offer(next);
//            }
//        }
//
//        return answer.toArray(String[]::new);
//    }



	
//    public static int solution(String[][] clothes) {
//        int answer = 1;
//        
//        Map<String, Integer> kind = new HashMap<>();
//        for(String[] c : clothes){
//            String kindOfCloth = c[1];
//            kind.put(kindOfCloth, kind.getOrDefault(kindOfCloth, 0) + 1);
//         // 키값을 분류해서 하나하나씩 카운트를 진행한다. 
//            //처음에 없을시에는 0을 반환 후 1을더해줌으로 1이 될 수 있게 해준다.
//        }
//        System.out.println(kind);
//        
//        for(Integer c : kind.values()){
//            answer *= c + 1;
//        }
//        
//        answer -= 1;
//        
//        return answer;
//
//    }
	
//	public static Stack<Integer> stack;
//    public static int visitDepth;
//    public static int groupCount;
//
//    public static int solution(int[][] reply) {
//        // 변수들 초기화
//        visitDepth = 0;
//        groupCount = 0;
//        stack = new Stack<>();
//
//        Member[] members = new Member[reply.length];
//        List<List<Integer>> replies = new ArrayList<>();
//        for (int i = 0; i < members.length; i++) {
//            members[i] = new Member();
//            replies.add(new ArrayList<>());
//        }
//
//        // 회장(0)은 제외 하고 graph 생성
//        for (int i = 1; i < reply.length; i++) {
//            for (int k : reply[i]) {
//                replies.get(k).add(i);
//            }
//        }
//
//        for (int i = 1; i < reply.length; i++) {
//            if (members[i].groupNumber == -1) {
//                // 그룹이 결정 되지 않은 멤버들 그룹 짓기
//                groupingDFS(members, replies, i);
//            }
//        }
//
//        boolean[] skip = new boolean[groupCount];
//        for (int i = 1; i < replies.size(); i++) {
//            for (int k : replies.get(i)) {
//                if (members[i].groupNumber != members[k].groupNumber) {
//                    // 같은 그룹이 아닌데 그래프 연결점이 있는 경우 skip한다.
//                    skip[members[k].groupNumber] = true;
//                }
//            }
//        }
//
//        int answer = 0;
//        for (int i = 0; i < groupCount; i++) {
//            if (!skip[i]) {
//                answer++; // skip되지 않은 그룹들만 카운트
//            }
//        }
//        return answer;
//    }
//
//
//    private static int groupingDFS(Member[] members, List<List<Integer>> replies, int num) {
//        members[num].visited = visitDepth;
//        stack.push(num);
//
//        int ret = visitDepth;
//        visitDepth += 1;
//
//        for (int k : replies.get(num)) {
//            if (members[k].visited == -1) {
//                // 방문하지 않았으면 DFS로 연결된 모든 곳을 방문
//                ret = Math.min(ret, groupingDFS(members, replies, k)); // 여러 그룹과 연결된 경우 첫번째 그룹을 선택
//            }
//            if (members[k].groupNumber == -1) {
//                // 이미 그룹이 결정된 경우
//                ret = Math.min(ret, members[k].visited); // 더 먼저 방문했던 쪽으로 결정
//            }
//        }
//
//        // 순환루프를 찾은 경우
//        if (ret == members[num].visited) {
//            while (true) {
//                int now = stack.pop();
//                // 순환하는 동아리원들에게 같은 그룹값(groupCount)을 갖도록 함
//                members[now].groupNumber = groupCount;
//                if (now == num) break;
//            }
//            // 순환그룹 개수 증가
//            groupCount++;
//        }
//
//        return ret;
//    }
//    public static int solution(int[] bell) {
//        for(int i=0; i<bell.length; i++) {
//          // 절대값 측정을 위해 -1로 값 변경
//            if(bell[i] == 2) {
//                bell[i] = -1;
//            }
//            System.out.println(bell[i]);
//        }
//        
//        int total = bell[0]; // 첫번째 방울의 값
//        int answer = 0;
//        
//        // <방울의 값들의 합, 현재 누적합이 처음으로 나온 인덱스>
//        Map<Integer, Integer> dict = new HashMap<>();
//        dict.put(0, -1);
//        dict.put(total, 0);
//        
//        for(int i=1; i<bell.length; i++) {
//            total += bell[i];
//            if(!dict.containsKey(total)) {
//                // 누적합이 처음 나온 경우, 인덱스를 저장
//                dict.put(total, i);
//            } else {
//              // 처음 방문한 지점의 인덱스부터 현재 인덱스까지 짝이 맞아있음을 의미
//                answer = Math.max(answer, i - dict.get(total));
//            }
//        }
//        
//        return answer;
//    }
//	 public static int[] solution(int[] array, int[][] commands) {
//	        int[] answer = new int[commands.length];
//	        for(int i = 0; i < commands.length; i++){
//	            int[] arr = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
//	            System.out.println(arr.length);
//	            Arrays.sort(arr);
//	            for(int j =0; j < arr.length; j++) {
//	            	System.out.println(arr[j]);
//	            }
//	            answer[i] = arr[commands[i][2]-1];
//	            System.out.println(answer[i]);
//	        }
//
//	        
//	        return answer;
//	    }
	
//	public static int solution(int[] coin, int k) {
//        // 동전이 하나면 뒤집을 필요 없음
//        if (coin.length == 1) return 0;
//
//        int sum = IntStream.of(coin).sum();
//        // 모두 0이면 sum은 0, 모두 1일 때 sum은 coin.length
//        if (sum == 0 || sum == coin.length) return 0; // 뒤집을 필요 없음
//        if (sum != k && coin.length == k) return -1; // 불가
//
//        // flipCoins 로 전달되는 배열의 내용이 변경되기 때문에 Arrays.copyOf 로 배열의 복사본을 전달합니다.
//        int makeAll0 = flipCoins(Arrays.copyOf(coin, coin.length), k, 0); // 모두 0으로 만들 경우
//        int makeAll1 = flipCoins(Arrays.copyOf(coin, coin.length), k, 1); // 모두 1로 만들 경우
//        int answer = Math.min(makeAll0, makeAll1);
//        if (answer == Integer.MAX_VALUE) return -1;
//        return answer;
//    }
//
//    public static int flipCoins(int[] coin, int k, int t) {
//        int ret = 0;
//
//        for (int i = 0; i < coin.length - k + 1; i++) {
//            if (coin[i] == t) continue; // 이미 원하는 값인 경우 스킵
//
//            for (int j = 0; j < k; j++) {
//                coin[i + j] = 1 - coin[i + j]; // 뒤집기 : 0 -> 1, 1 -> 0
//            }
//
//            ret += 1; // 뒤집은 횟수
//        }
//
//        int count = 0;
//        for (int c : coin) if (c == t) count += 1; // 원하는 값의 개수 세기
//
//        if (count == coin.length) return ret;
//        return Integer.MAX_VALUE;
//    }

}
