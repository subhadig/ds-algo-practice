// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/

// time: O(n)

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node head2 = new Node(0);
        Node n = head2;
        while(head != null) {
            Node tmp = head.next;
            n.next = head;
            n.next.next = new Node(head.val);
            head = tmp;
            n = n.next.next;
        }
        head2 = head2.next;
        
        n = head2;
        while(n != null) {
            if(n.random != null) {
                n.next.random = n.random.next;
            }
            n = n.next.next;
        }
        
        Node head3 = new Node(0);
        n = head2;
        Node n1 = head3;
        while(n != null) {
            n1.next = n.next;
            n.next = n.next.next;
            n = n.next;
            n1 = n1.next;
        }
        return head3.next;
    }
}

