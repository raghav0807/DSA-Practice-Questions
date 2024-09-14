import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        Map<String, Integer> visited = new HashMap<>();
        visited.put(beginWord, 1);
        
        while (!queue.isEmpty()) {
            String currentWord = queue.poll();
            int currentLength = visited.get(currentWord);
            
            for (int i = 0; i < currentWord.length(); i++) {
                char[] wordArray = currentWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordArray[i] = c;
                    String newWord = new String(wordArray);
                    
                    if (newWord.equals(endWord)) {
                        return currentLength + 1;
                    }
                    
                    if (wordSet.contains(newWord) && !visited.containsKey(newWord)) {
                        visited.put(newWord, currentLength + 1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
}

