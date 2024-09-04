class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  
  // Deserialization method
  public static ListNode deserialize(String data) {
      if (data.equals("[]")) return null;
      String[] parts = data.substring(1, data.length() - 1).split(",");
      ListNode dummy = new ListNode(0);
      ListNode current = dummy;
      for (String part : parts) {
          current.next = new ListNode(Integer.parseInt(part.trim()));
          current = current.next;
      }
      return dummy.next;
  }
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode dummyHead = new ListNode(0);
      ListNode current = dummyHead;
      int carry = 0;
      
      while (l1 != null || l2 != null || carry != 0) {
          int x = (l1 != null) ? l1.val : 0;
          int y = (l2 != null) ? l2.val : 0;
          int sum = carry + x + y;
          carry = sum / 10;
          current.next = new ListNode(sum % 10);
          current = current.next;
          
          if (l1 != null) l1 = l1.next;
          if (l2 != null) l2 = l2.next;
      }
      
      return dummyHead.next;
  }
}

