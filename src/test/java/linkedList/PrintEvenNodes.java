package linkedList;

import org.junit.Test;
import week4.PrintOddNodes;

public class PrintEvenNodes {
    /*
    Given a linked list, print only the even nodes
    Eg: 1->2->3->4->5->6 output- 2->4->6
     */
    public class Node {
        int value;
        Node next;

        Node(int key) {
            this.value = key;
            next = null;
        }

        Node() {
            this.next = null;
        }
    }

    public Node addNode(int key) {
        return new Node(key);
    }

    public void printAllNodes(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
    @Test
    public void test() {
       Node head1 = addNode(1);
        head1.next = addNode(2);
        head1.next.next = addNode(3);
        head1.next.next.next = addNode(4);
        head1.next.next.next.next = addNode(5);
        head1.next.next.next.next.next = addNode(6);
        Node node = printEvenNodes(head1);
        printAllNodes(node);

    }
    /*
    Solution:-
    - Initialize two nodes called, even=head.next newNode=even
    - while even!=null && even.next!=null
    - connect the head.next with even.next and move head to its next
    - connect even with odd.next and move even to its next
    - return newNode

     */
    private Node printEvenNodes(Node node){
        Node even=node.next, newNode=even;
        while (even!=null && even.next!=null){
            node.next=even.next;
            node=node.next;
            even.next=node.next;
            even=even.next;
        }
        return newNode;
    }
}
