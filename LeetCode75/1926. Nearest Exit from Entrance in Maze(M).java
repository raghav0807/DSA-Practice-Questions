import java.util.*;

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        queue.offer(new int[]{entrance[0], entrance[1], 0}); 
        visited[entrance[0]][entrance[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], steps = current[2];
            
            
            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1) && 
                (row != entrance[0] || col != entrance[1])) {
                return steps;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0], newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && 
                    maze[newRow][newCol] == '.' && !visited[newRow][newCol]) {
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                    visited[newRow][newCol] = true;
                }
            }
        }
        
        return -1; 
    }
}

