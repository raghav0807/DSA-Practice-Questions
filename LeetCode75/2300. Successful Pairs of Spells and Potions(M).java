class Solution {
  public int[] successfulPairs(int[] spells, int[] potions, long success) {
      int n = spells.length;
      int m = potions.length;
      int[] pairs = new int[n];
      
      // Sort the potions array
      Arrays.sort(potions);
      
      for (int i = 0; i < n; i++) {
          // Find the minimum potion strength needed
          long minStrength = (success + spells[i] - 1) / spells[i];
          
          // Binary search to find the index of the first potion that works
          int index = binarySearch(potions, minStrength);
          
          // Count successful pairs
          pairs[i] = m - index;
      }
      
      return pairs;
  }
  
  private int binarySearch(int[] potions, long target) {
      int left = 0;
      int right = potions.length;
      
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (potions[mid] < target) {
              left = mid + 1;
          } else {
              right = mid;
          }
      }
      
      return left;
  }
}

