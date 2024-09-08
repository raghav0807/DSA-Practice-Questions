class Solution {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
      // Create adjacency list representation of the graph
      List<List<Integer>> graph = new ArrayList<>(numCourses);
      for (int i = 0; i < numCourses; i++) {
          graph.add(new ArrayList<>());
      }
      for (int[] prereq : prerequisites) {
          graph.get(prereq[0]).add(prereq[1]);
      }
      
      // Array to keep track of visited nodes
      boolean[] visited = new boolean[numCourses];
      // Array to keep track of nodes in the current DFS path
      boolean[] onPath = new boolean[numCourses];
      
      // Perform DFS on each node
      for (int i = 0; i < numCourses; i++) {
          if (hasCycle(i, graph, visited, onPath)) {
              return false;
          }
      }
      
      return true;
  }
  
  private boolean hasCycle(int node, List<List<Integer>> graph, boolean[] visited, boolean[] onPath) {
      if (onPath[node]) {
          return true;
      }
      
      if (visited[node]) {
          return false;
      }
      
      visited[node] = true;
      onPath[node] = true;
      
      for (int neighbor : graph.get(node)) {
          if (hasCycle(neighbor, graph, visited, onPath)) {
              return true;
          }
      }
      
      onPath[node] = false;
      
      return false;
  }
}