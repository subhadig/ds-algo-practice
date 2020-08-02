// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1205/

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
    public ListNode reverseList(ListNode head) {
        ListNode n = head;
        ListNode prev = null;
        ListNode tmp;
        while(n != null) {
            tmp = n.next;
            n.next = prev;
            prev = n;
            n = tmp;
        }
        return prev;
    }
}
