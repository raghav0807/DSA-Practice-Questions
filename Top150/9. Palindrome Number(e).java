class Solution {
  public boolean isPalindrome(int x) {
      int rev=0;
      int target =x;
      while(x>0)
      {
          int temp = x%10;
          x=x/10;
          rev = (rev*10)+temp;
      }
      return rev==target;
  }
}
