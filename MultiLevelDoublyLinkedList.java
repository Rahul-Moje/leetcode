package main.java.com.leetcode;

import java.util.HashMap;

public class MultiLevelDoublyLinkedList {

    private Node head,head2,head3;

    public static void main(String[] args) {
        MultiLevelDoublyLinkedList obj = new MultiLevelDoublyLinkedList();
        Node head = obj.setupData();
        obj.printList(head);
        head = obj.flatten(head);
        //obj.printList(head);
    }

    private void printList(Node head) {

        while (head != null){
            System.out.print("Current value - " + head.val + " ");
            if(head.prev != null)
                System.out.print("Previous value - " + head.prev.val + " ");
            if(head.next != null)
                System.out.print("Next value - " + head.next.val + " ");
            if(head.child != null)
                System.out.print("Child value - "  + head.child.val + " .This should be null after flattening!!!!");
            System.out.println();
            head = head.next;
        }
    }

    public Node flatten(Node head) {
        if(head == null)
            return head;
        else
        {
            Node temp = head;
            flattenRecursive(head);
            return temp;
        }
    }
    public Node flattenRecursive(Node head){
        if(head == null)
            return head;
        else {
            while (true){
                if (head.child != null){
                    Node tail = flattenRecursive(head.child);
                    tail.next = head.next;
                    if(tail.next != null)
                        head.next.prev = tail;
                    head.next = head.child;
                    head.child.prev = head;
                    head.child = null;
                    head = tail;
                }
                else {
                    if(head.next == null)
                        break;
                    else
                        head = head.next;
                }
            }
            return head;
        }
    }


    private Node setupData() {
        head =  insertNode(1,null);
        Node node = insertNode(2, head);
        node = insertNode(3, head);
        Node child3 = node;
        insertNode(4, head);
        insertNode(5, head);
        insertNode(6, head);
        head2 = insertNode(7,null);
        node = insertNode(8,head2);
        Node child8 = node;
        insertNode(9,head2);
        insertNode(10,head2);
        head3 = insertNode(11,null);
        insertNode(12,head3);
        child3.child = head2;
        child8.child = head3;
        return head;
    }

    private static Node insertNode(int i, Node node) {
        if(node == null)
            return new Node(i);
        else {
            while (node.next!=null)
                node = node.next;
            Node newNode = new Node(i);
            newNode.prev = node;
            node.next = newNode;
            return newNode;
        }
    }
}
class Node{

    int val;
    Node prev;
    Node next;
    Node child;

    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
        this.child = null;
    }
}
