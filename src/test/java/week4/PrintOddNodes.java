package week4;

import org.junit.Test;

public class PrintOddNodes {

    public class Node {
        int value;
        Node next;

        Node(int key) {
            this.value = key;
            next = null;
        }

        Node() {
            // this.value = key;
            next = null;
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

    private Node printOddnodes(Node n) {
        Node oddNodes = new Node();
        Node current = oddNodes;
        while (n != null) {
            current.next = n;
            n=n.next==null?n.next:n.next.next;
            current = current.next;
            current.next=null;
        }

        return oddNodes.next;
    }
    private Node printOddsUsingRecusrsion(Node n){

        if(n==null)
            return null;
        return n.next=printOddsUsingRecusrsion(n.next.next);


    }


    @Test
    public void test() {
        Node head1 = addNode(1);
        head1.next = addNode(2);
        head1.next.next = addNode(3);
        head1.next.next.next = addNode(4);
        head1.next.next.next.next = addNode(5);
        head1.next.next.next.next.next = addNode(6);
        Node node = printOddnodes(head1);
        printAllNodes(node);


    }
}