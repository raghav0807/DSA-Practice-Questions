class Solution {
  public int minEatingSpeed(int[] piles, int h) {
      int left = 1;
      int right = getMaxPile(piles);
      
      while (left < right) {
          int mid = left + (right - left) / 2;
          if (canEatAll(piles, h, mid)) {
              right = mid;
          } else {
              left = mid + 1;
          }
      }
      
      return left;
  }
  
  private boolean canEatAll(int[] piles, int h, int k) {
      int hoursNeeded = 0;
      for (int pile : piles) {
          hoursNeeded += (pile - 1) / k + 1;
      }
      return hoursNeeded <= h;
  }
  
  private int getMaxPile(int[] piles) {
      int max = 0;
      for (int pile : piles) {
          max = Math.max(max, pile);
      }
      return max;
  }
}
