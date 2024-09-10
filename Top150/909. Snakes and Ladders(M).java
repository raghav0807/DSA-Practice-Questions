import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int target = n * n;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(1);
        visited.add(1);
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == target) {
                    return moves;
                }
                for (int next = current + 1; next <= Math.min(current + 6, target); next++) {
                    int[] pos = getPosition(next, n);
                    int row = pos[0], col = pos[1];
                    int destination = board[row][col] == -1 ? next : board[row][col];
                    if (!visited.contains(destination)) {
                        queue.offer(destination);
                        visited.add(destination);
                    }
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] getPosition(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (square - 1) % n;
        if ((n - row) % 2 == 0) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }
}
