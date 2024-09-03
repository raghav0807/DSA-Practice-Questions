class Solution {
  public boolean isIsomorphic(String s, String t) {
      if (s.length() != t.length()) {
          return false;
      }

      int[] mapStoT = new int[256];
      int[] mapTtoS = new int[256];

      for (int i = 0; i < s.length(); i++) {
          char charS = s.charAt(i);
          char charT = t.charAt(i);

          if (mapStoT[charS] == 0 && mapTtoS[charT] == 0) {
              mapStoT[charS] = charT;
              mapTtoS[charT] = charS;
          
          
           } 
           else if (mapStoT[charS] != charT || mapTtoS[charT] != charS) {
              return false;
          }
      }

      return true;
  }
}

