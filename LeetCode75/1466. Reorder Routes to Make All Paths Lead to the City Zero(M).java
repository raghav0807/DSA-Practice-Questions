import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] connection : connections) {
            int from = connection[0];
            int to = connection[1];
            adjList.get(from).add(new int[]{to, 1});
            adjList.get(to).add(new int[]{from, 0}); 
        }
        
        int reorderCount = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        
        queue.offer(0);  
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int[] neighbor : adjList.get(city)) {
                int nextCity = neighbor[0];
                int direction = neighbor[1];
                
                if (!visited[nextCity]) {
                    visited[nextCity] = true;
                    queue.offer(nextCity);
                    reorderCount += direction;  
                }
            }
        }
        
        return reorderCount;
    }
}


