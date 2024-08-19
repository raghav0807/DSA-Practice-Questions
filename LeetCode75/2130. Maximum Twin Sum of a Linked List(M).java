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
  public int pairSum(ListNode head) {
      ListNode slow = head;
      ListNode fast = head;
      while (fast != null && fast.next != null) {
          slow = slow.next;
          fast = fast.next.next;
      }
      
      ListNode secondHalf = reverseList(slow);
      
      int maxTwinSum = 0;
      ListNode first = head;
      ListNode second = secondHalf;
      while (second != null) {
          maxTwinSum = Math.max(maxTwinSum, first.val + second.val);
          first = first.next;
          second = second.next;
      }
      
      return maxTwinSum;
  }
  
  private ListNode reverseList(ListNode head) {
      ListNode prev = null;
      ListNode current = head;
      while (current != null) {
          ListNode nextTemp = current.next;
          current.next = prev;
          prev = current;
          current = nextTemp;
      }
      return prev;
  }
}

