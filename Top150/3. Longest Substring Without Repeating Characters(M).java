class Solution {
  public int lengthOfLongestSubstring(String s) {
      int[] charIndex = new int[128]; 
      int maxLength = 0;
      int start = 0;
      
      for (int end = 0; end < s.length(); end++) {
          char c = s.charAt(end);
          if (charIndex[c] > start) {
              start = charIndex[c];
          } 
          else {
              maxLength = Math.max(maxLength, end - start + 1);
          }
          
          charIndex[c] = end + 1;
      }
      
      return maxLength;
  }
}