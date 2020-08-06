// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1229/

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
        print(head);
        Node head2 = new Node(0);
        Node n = head2;
        while(head != null) {
            Node tmp = head.next;
            n.next = head;
            n.next.next = new Node(head.val);
            head = tmp;
            n = n.next.next;
        }
        print(head2.next);
        
        head2 = head2.next;
        Node head3 = new Node(0);
        n = head3;
        Node n1 = head2;
        while(n1 != null) {
            n.next = n1.next;
            if(n1.random != null) {
                n.next.random = n1.random.next;
            }
            n = n.next;
            n1 = n1.next.next;
        }
        print(head3.next);
        
        n = head2;
        while(n != null) {
            n.next = n.next.next;
            n = n.next;
        }
        print(head2.next);
        return head3.next;
    }
    
    private void print(Node head) {
        StringBuilder sb = new StringBuilder("[");
        while(head != null) {
            sb.append("[" + head.val + "," + (head.random == null ? "null" : head.random.val) + "],");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
}
