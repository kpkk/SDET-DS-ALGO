package linkedList;

import org.junit.Test;

public class PrintOddNodes {
    /*
    Given a linked list print only its odd nodes
    eg: 1->2->3->4->5->6, output- 1->3->5
     */
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

    @Test
    public void test1(){
       Node head=addNode(1);
        head.next=addNode(2);
        head.next.next=addNode(3);
        head.next.next.next=addNode(4);
        head.next.next.next.next=addNode(5);
        head.next.next.next.next.next=addNode(6);
        Node node = printOddNodes(head);
        printAllNodes(node);
    }

    /*
    Solution:-
    - Initialize nodes called odd=node, current=node.next
    - while the current!=null & current.next is not null
    - connect the node.next with current.next
    - move the node to node.next
    - connect the current.next=odd.next and move current=current.next
    - return odd

     */
    private Node printOddNodes(Node node){
        Node odd=node, current=odd.next;
        while (current!=null && current.next!=null){
            node.next=current.next;
            node=node.next;
            current.next=node.next;
            current=current.next;
            node.next=null;
        }

        return odd;
    }
}
