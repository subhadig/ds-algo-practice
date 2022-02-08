// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1208/

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
    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode even = null;
        ListNode odd = null;
        ListNode oddHead = head;
        ListNode evenHead = null;
        int counter = 1;
        while(head != null) {
            if(counter % 2 == 0) {
                if(even == null) {
                    even = head;
                    evenHead = even;
                } else {
                    even.next = head;
                    even = even.next;
                }
            } else {
                if(odd == null) {
                    odd = head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            }
            head = head.next;
            counter++;
        }
        odd.next = evenHead;
        if(even != null) {
            even.next = null;
        }
        return oddHead;
    }
}
