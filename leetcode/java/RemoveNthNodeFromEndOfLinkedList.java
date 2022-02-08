// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1296/

// time: O(n), space: O(1)

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = 0;
        ListNode n1 = head;
        ListNode n2 = null;
        
        while(n1 != null) {
            n1 = n1.next;
            i++;
            if(i == n + 1) {
                n2 = head;
            } else if(i > n + 1) {
                n2 = n2.next;
            }
        }
        if(n2 == null) {
            return head.next;
        }
        n2.next = n2.next.next;
        return head;
    }
}
