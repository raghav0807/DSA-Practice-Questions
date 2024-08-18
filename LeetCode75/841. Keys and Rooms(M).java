import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[0] = true;
        queue.offer(0);
        
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.offer(key);
                }
            }
        }
        
        for (boolean room : visited) {
            if (!room) return false;
        }
        
        return true;
    }
}



