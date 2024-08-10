import java.util.*;

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headWorkers = new PriorityQueue<>();
        PriorityQueue<Integer> tailWorkers = new PriorityQueue<>();
        
        int i = 0;
        int j = costs.length - 1;
        long answer = 0;
        
        while (k > 0) {
            while (headWorkers.size() < candidates && i <= j) {
                headWorkers.offer(costs[i]);
                i++;
            }
            while (tailWorkers.size() < candidates && i <= j) {
                tailWorkers.offer(costs[j]);
                j--;
            }
            
            int headTop = headWorkers.isEmpty() ? Integer.MAX_VALUE : headWorkers.peek();
            int tailTop = tailWorkers.isEmpty() ? Integer.MAX_VALUE : tailWorkers.peek();
            
            if (headTop <= tailTop) {
                answer += headTop;
                headWorkers.poll();
            } else {
                answer += tailTop;
                tailWorkers.poll();
            }
            
            k--;
        }
        
        return answer;
    }
}

// 2462. Total Cost to Hire K Workers(M).java