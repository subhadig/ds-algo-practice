// https://leetcode.com/explore/learn/card/linked-list/213/conclusion/1225/

// O(n)

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        return flattenChild(head)[0];
    }
    
    private Node[] flattenChild(Node head) {
        Node[] rNodes = new Node[2];
        rNodes[0] = head;
        while(head != null) {
            if(head.child != null) {
                Node tmp = head.next;
                Node[] nodes = flattenChild(head.child);
                head.child = null;
                
                //head -> child head node
                head.next = nodes[0];
                nodes[0].prev = head;
                
                //child tail node -> head.next
                nodes[1].next = tmp;
                if(tmp != null) {
                    tmp.prev = nodes[1];
                }
                
                rNodes[1] = nodes[1];
                head = tmp;
            } else {
                rNodes[1] = head;
                head = head.next;
            }
        }
        return rNodes;
    }
}
