import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        int required = tCount.size();
        HashMap<Character, Integer> windowCount = new HashMap<>();
        
        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        String minWindow = "";
        
        int formed = 0;
        
        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);
            
            if (tCount.containsKey(c) && windowCount.get(c).intValue() == tCount.get(c).intValue()) {
                formed++;
            }
            
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minWindow = s.substring(left, right + 1);
                }
                
                windowCount.put(c, windowCount.get(c) - 1);
                if (tCount.containsKey(c) && windowCount.get(c).intValue() < tCount.get(c).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            right++;
        }
        
        return minWindow;
    }
}
