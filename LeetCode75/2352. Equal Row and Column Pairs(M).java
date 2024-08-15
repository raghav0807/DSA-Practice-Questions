class Solution {
  public int equalPairs(int[][] grid) {
      Map<String,Integer> mp = new HashMap<>();
          for(int[] g : grid) {
          String temp = "";
          for(int r : g) {
              temp += "+" + r;
          }
          mp.put(temp,mp.getOrDefault(temp,0)+1);
      }
      
      int res = 0;
      
      for(int i=0; i<grid.length; i++) {
          String temp = "";
          for(int j=0; j<grid[0].length; j++) {
             temp += "+" + grid[j][i];
          }
          res += mp.getOrDefault(temp,0);
      }
      return res;
  }
}

