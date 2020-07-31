// https://leetcode.com/explore/learn/card/linked-list/214/two-pointer-technique/1214/


// time: O(n), space: O(1)

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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null) {
            return null;
        }
        
        ListNode n1 = head;
        ListNode n2 = head;
        while(n2 != null && n2.next != null) {
            if(n2.next == n1) {
                //n1 is at A+B. 
                //Since A=N-B, n1 needs to travel A to be at N.
                n1 = n1.next;
                ListNode n3 = head;
                while(n3 != n1) {
                    n3 = n3.next;
                    n1 = n1.next;
                }
                return n1;
            }
            n1 = n1.next; //Move by one step
            n2 = n2.next.next; //Move by two steps
        }
        return null;
    }
}
