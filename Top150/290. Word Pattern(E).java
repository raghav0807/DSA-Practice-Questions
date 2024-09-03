class Solution {
  public boolean wordPattern(String pattern, String s) {
      String[] words = s.split(" ");
      if (words.length != pattern.length()) {
          return false;
      }

      Map<Character, String> charToWord = new HashMap<>();
      Map<String, Character> wordToChar = new HashMap<>();

      for (int i = 0; i < pattern.length(); i++) {
          char c = pattern.charAt(i);
          String word = words[i];

          if (!charToWord.containsKey(c) && !wordToChar.containsKey(word)) {
              charToWord.put(c, word);
              wordToChar.put(word, c);
          } 
          else if (!word.equals(charToWord.get(c)) || c != wordToChar.get(word)) {
              return false;
          }
      }

      return true;
  }
}
