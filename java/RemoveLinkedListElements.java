// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1207/

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
    public ListNode removeElements(ListNode head, int val) {
        ListNode n = head;
        ListNode prev = null;
        while(n != null) {
            if(n.val == val) {
                n = n.next;
                if(prev != null) {
                    prev.next = n;
                } else {
                    head = n;
                }
            } else {
                prev = n;
                n = n.next;
            }
        }
        return head;
    }
}
