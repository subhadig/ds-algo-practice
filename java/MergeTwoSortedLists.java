// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1227/

// time: O(n)
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode tail = head;
        
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            tail = tail.next;
        }
        while(l1 != null) {
            tail.next = new ListNode(l1.val);
            l1 = l1.next;
            tail = tail.next;
        }
        while(l2 != null) {
            tail.next = new ListNode(l2.val);
            l2 = l2.next;
            tail = tail.next;
        }
        return head.next;
    }
}

// Using recursion
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        } else if(l2 == null) {
            return l1;
        } else if(l1.val < l2.val) {
            ListNode head = l1;
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            ListNode head = l2;
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        
    }
}
