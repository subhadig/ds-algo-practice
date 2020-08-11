// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1295/

// O(n)
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
        if(head == null) {
            return head;
        }
        
        int l = 1;
        ListNode tail = head;
        while(tail.next != null) {
            tail = tail.next;
            l++;
        }
        
        int i = 1;
        ListNode newHead = head;
        k = k % l;
        while(i <= l - k) {
            newHead = newHead.next;
            if(newHead == null) {
                newHead = head;
            }
            i++;
        }
        
        ListNode n = head;
        while(n != newHead) {
            tail.next = n;
            tail = tail.next;
            n = n.next;
        }
        tail.next = null;
        
        return newHead;
    }
}
