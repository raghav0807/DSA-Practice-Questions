class Solution {
  public int numTilings(int n) {
      if (n <= 2) return n;
      
      long MOD = 1_000_000_007;
      
      long[] f = new long[n + 1];
      long[] p = new long[n + 1];
      
      f[1] = 1;
      f[2] = 2;
      p[2] = 1;
      
      for (int i = 3; i <= n; i++) {
          f[i] = (f[i-1] + f[i-2] + 2 * p[i-1]) % MOD;
          p[i] = (f[i-2] + p[i-1]) % MOD;
      }
      
      return (int) f[n];
  }
}
