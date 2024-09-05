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
  public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null || k == 0) {
          return head;
      }
      
      ListNode last = head;
      int length = 1;
      while (last.next != null) {
          last = last.next;
          length++;
      }
      
      last.next = head;
      
      k = k % length; 
      int stepsToNewLast = length - k - 1;
      ListNode newLast = head;
      for (int i = 0; i < stepsToNewLast; i++) {
          newLast = newLast.next;
      }
      
      head = newLast.next;
      newLast.next = null;
      
      return head;
  }
}