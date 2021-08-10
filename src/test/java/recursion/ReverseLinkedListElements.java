package recursion;

import org.junit.Test;

public class ReverseLinkedListElements {
    /*
    Reverse the given linked list elements using recursive approach
     */

    public class Node {
        int value;
        Node next;

        Node() {
            this.next = null;
        }

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public Node addNode(int value) {
        return new Node(value);
    }

    public void printAllNodes(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }

    private Node reverseLinkeListEle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextNode = head.next;
        Node newNode = reverseLinkeListEle(head.next);
        nextNode.next = head;
        head.next = null;
        return newNode;
    }

    @Test
    public void test1() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        Node node = reverseLinkeListEle(head);
        printAllNodes(node);

    }
}