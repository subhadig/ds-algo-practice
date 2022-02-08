// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1215/

// time: O(m+n), space: O(1)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) {
            return null;
        }
        
        ListNode nA = headA;
        ListNode nB = headB;
        
        while(nA != nB) {
            if(nA == null) {
                nA = headB;
            } else if(nB == null) {
                nB = headA;
            } else {
                nA = nA.next;
                nB = nB.next;
            }
        }
        
        return nA;
    }
}
