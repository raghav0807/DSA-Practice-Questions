import java.util.*;

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        
        Arrays.sort(index, (a, b) -> nums2[b] - nums2[a]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        long sum = 0;
        long result = 0;
        
        for (int i = 0; i < n; i++) {
            int idx = index[i];
            sum += nums1[idx];
            pq.offer(nums1[idx]);
            
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            
            if (pq.size() == k) {
                result = Math.max(result, sum * nums2[idx]);
            }
        }
        
        return result;
    }
}

