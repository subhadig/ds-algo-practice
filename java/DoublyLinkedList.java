// https://leetcode.com/explore/learn/card/linked-list/210/doubly-linked-list/1294/

class MyLinkedList {
    
    static class Node {
        int val;
        Node next;
        Node prev;
        
        Node(int val) {
            this.val = val;
        }
    }
    
    Node head;
    Node tail;
    int length = 0;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length) {
            return -1;
        }
        
        Node n = getNode(index);
        return n.val;
    }
    
    private Node getNode(int index) {
        Node n = head;
        int i = 0;
        while(i != index) {
            n = n.next;
            i++;
        }
        return n;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        if(head == null) {
            head = n;
            tail = head;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
        length++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = new Node(val);
        if(tail == null) {
            tail = n;
            head = tail;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        length++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length) {
            return;
        } else if(index == length) {
            addAtTail(val);
            return;
        } else if(index == 0) {
            addAtHead(val);
            return;
        }
        
        Node n = new Node(val);
        Node prev = getNode(index - 1);
        //System.out.println("Prev node: " + prev.val);
        n.next = prev.next;
        prev.next = n;
        if(n.next != null) {
            n.next.prev = n;
        }
        n.prev = prev;
        
        length++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length) {
            return;
        }
        if(index == 0) {
            if(head.next != null) {
                head.next.prev = null;
            }
            head = head.next;
        } else if(index == length - 1) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            Node n = getNode(index);
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

