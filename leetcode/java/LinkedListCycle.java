// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1212/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode n1 = head;
        ListNode n2 = head;
        while(n1.next != null && n2.next != null && n2.next.next != null && n2.next != n1) {
            n1 = n1.next;
            n2 = n2.next.next;
        }
        return n2.next == n1;
    }
}
