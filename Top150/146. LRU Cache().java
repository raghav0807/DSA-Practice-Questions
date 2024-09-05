class LRUCache {
  class Node {
      int key;
      int value;
      Node prev;
      Node next;
      
      Node(int key, int value) {
          this.key = key;
          this.value = value;
      }
  }
  
  private Map<Integer, Node> cache;
  private int capacity;
  private Node head;
  private Node tail;

  public LRUCache(int capacity) {
      this.capacity = capacity;
      this.cache = new HashMap<>();
      this.head = new Node(0, 0);
      this.tail = new Node(0, 0);
      head.next = tail;
      tail.prev = head;
  }
  
  public int get(int key) {
      if (cache.containsKey(key)) {
          Node node = cache.get(key);
          remove(node);
          add(node);
          return node.value;
      }
      return -1;
  }
  
  public void put(int key, int value) {
      if (cache.containsKey(key)) {
          remove(cache.get(key));
      }
      if (cache.size() == capacity) {
          remove(tail.prev);
      }
      add(new Node(key, value));
  }
  
  private void add(Node node) {
      cache.put(node.key, node);
      node.next = head.next;
      node.next.prev = node;
      head.next = node;
      node.prev = head;
  }
  
  private void remove(Node node) {
      cache.remove(node.key);
      node.prev.next = node.next;
      node.next.prev = node.prev;
  }
}

