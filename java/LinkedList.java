// https://leetcode.com/explore/learn/card/linked-list/209/singly-linked-list/1290/

class MyLinkedList {
    
    static class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    
    private int length;

    /** Initialize your data structure here. */
    public MyLinkedList() {
        print();
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= length) {
            return -1;
        }
        
        return getNode(index).val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node n = new Node(val);
        
        if(head == null) {
            head = n;
        } else {
            n.next = head;
            head = n;
        }
        length++;
        print();
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node n = head;
        
        while(n.next != null) {
            n = n.next;
        }
        
        n.next = new Node(val);
        length++;
        print();
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > length) {
            return;
        }
        
        Node n = getNode(index - 1);
        
        if(index == 0) {
            addAtHead(val);
            return;
        } if(index == length) {
            n.next = new Node(val);
        } else {
            Node n1 = n.next;
            n.next = new Node(val);
            n.next.next = n1;
        }
        
        length++;
        print();
    }
    
    private Node getNode(int index) {
        int i = 0;
        Node n = head;
        
        while(i < index) {
            if(n.next != null) {
                n = n.next;
                i++;
            } else {
                break;
            }
        }
        return n;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= length) {
            return;
        } else if(index == 0) {
            head = head.next;
            return;
        }
        
        Node n = getNode(index - 1);
        
        if(n.next.next == null) {
            n.next = null;
        } else {
            n.next = n.next.next;
        }
        print();
    }
    
    private void print() {
        Node n = head;
        List l = new ArrayList();
        while(n != null) {
            l.add(n.val);
            n = n.next;
        }
        System.out.println(l);
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
