import java.util.*;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalLength = wordLength * words.length;
        
        if (s.length() < totalLength) {
            return result;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seenWords = new HashMap<>();
            int j;
            for (j = 0; j < words.length; j++) {
                int startIndex = i + j * wordLength;
                String currentWord = s.substring(startIndex, startIndex + wordLength);
                
                if (!wordCount.containsKey(currentWord)) {
                    break;
                }

                seenWords.put(currentWord, seenWords.getOrDefault(currentWord, 0) + 1);

                if (seenWords.get(currentWord) > wordCount.getOrDefault(currentWord, 0)) {
                    break;
                }
            }

            if (j == words.length) {
                result.add(i);
            }
        }

        return result;
    }
}
