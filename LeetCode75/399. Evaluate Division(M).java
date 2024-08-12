import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            double value = values[i];
            
            graph.computeIfAbsent(var1, k -> new HashMap<>()).put(var2, value);
            graph.computeIfAbsent(var2, k -> new HashMap<>()).put(var1, 1.0 / value);
        }
        
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            
            if (!graph.containsKey(var1) || !graph.containsKey(var2)) {
                results[i] = -1.0;
            } else if (var1.equals(var2)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, var1, var2, visited);
            }
        }
        
        return results;
    }
    
    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, Set<String> visited) {
        if (start.equals(end)) return 1.0;
        visited.add(start);
        
        Map<String, Double> neighbors = graph.get(start);
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            if (visited.contains(neighbor.getKey())) continue;
            double productWeight = dfs(graph, neighbor.getKey(), end, visited);

            if (productWeight != -1.0) {
                return productWeight * neighbor.getValue();
            }
        }
        
        return -1.0;
    }
}


