import java.util.*;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) return -1;
        
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        char[] chars = {'A', 'C', 'G', 'T'};
        
        queue.offer(startGene);
        visited.add(startGene);
        int mutations = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(endGene)) return mutations;
                
                char[] geneArray = current.toCharArray();
                for (int j = 0; j < 8; j++) {
                    char originalChar = geneArray[j];
                    for (char c : chars) {
                        geneArray[j] = c;
                        String newGene = new String(geneArray);
                        if (!visited.contains(newGene) && bankSet.contains(newGene)) {
                            queue.offer(newGene);
                            visited.add(newGene);
                        }
                    }
                    geneArray[j] = originalChar;
                }
            }
            mutations++;
        }
        
        return -1;
    }
}
