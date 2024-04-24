package leets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class P1345JG4 {

	public static int minJumps(int[] arr) {
		int n = arr.length;
        if (n == 1) 
            return 0;
        
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        Queue<Integer> storeIndex = new LinkedList<>();
        boolean[] visited = new boolean[n];
        storeIndex.offer(0);
        visited[0] = true;
        int steps = 0;
        
        while (!storeIndex.isEmpty()) {
            int size = storeIndex.size();
            while (size-- > 0) {
                int currIndex = storeIndex.poll();
                if (currIndex == n - 1) 
                    return steps;
                
                List<Integer> jumpNextIndices = indices.get(arr[currIndex]);
                jumpNextIndices.add(currIndex - 1);
                jumpNextIndices.add(currIndex + 1);
                for (int jumpNextIndex : jumpNextIndices) {
                    if (jumpNextIndex >= 0 && jumpNextIndex < n && !visited[jumpNextIndex]) {
                        storeIndex.offer(jumpNextIndex);
                        visited[jumpNextIndex] = true;
                    }
                }
                jumpNextIndices.clear();
            }
            steps++;
        }
        return -1;
    }
	

	public static void main(String[] args) {
		int arr[] = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
//		int arr[] = { 7 };
		int res = minJumps(arr);
		System.out.println(res);
	}
}
