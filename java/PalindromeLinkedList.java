// https://leetcode.com/explore/learn/card/linked-list/219/classic-problems/1209/

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
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null) {
            return true;
        }
        
        // find length
        int l = 0;
        ListNode n = head;
        while(n != null) {
            l++;
            n = n.next;
        }
        
        // find mid
        int mid = 0;
        if(l % 2 == 0) {
            mid = l/2;
        } else {
            mid = l/2;
        }
        
        // reverse second half of the list
        int i = 0;
        n = head;
        ListNode prev = null;
        while(n != null) {
            if(i > mid) {
                ListNode tmp = n.next;
                n.next = prev;
                prev = n;
                n = tmp;
            } else {
                prev = n;
                n = n.next;
            }
            i++;
        }
        
        // check palindrome
        i = 0;
        ListNode tail = prev;
        while(i < mid) {
            if(head.val != tail.val) {
                return false;
            }
            head = head.next;
            tail = tail.next;
            i++;
        }
        return true;
    }
}
