/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
      if (head == null || k == 1) {
          return head;
      }
      
      ListNode curr = head;
      for (int i = 0; i < k; i++) {
          if (curr == null) {
              return head;
          }
          curr = curr.next;
      }
      
      ListNode prev = null, next = null;
      curr = head;
      for (int i = 0; i < k; i++) {
          next = curr.next;
          curr.next = prev;
          prev = curr;
          curr = next;
      }
      
      head.next = reverseKGroup(curr, k);
      
      return prev;
  }
}
