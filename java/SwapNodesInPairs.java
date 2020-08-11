// https://leetcode.com/explore/learn/card/recursion-i/250/principle-of-recursion/1681/

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tmp = head.next.next; //3
        ListNode nHead = head.next; //2
        nHead.next = head; //2 -> 1
        head.next = swapPairs(tmp); //1 -> 4
        return nHead;
    }
}
