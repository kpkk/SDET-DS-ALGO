package week8;

import org.junit.Test;

public class P5_ReverseLinkedList {

    /*

    Given a list, reverse the list elements and return
    list 1->2->3->4
    output 4->3->2->1
     */
    public class Node{
        int value;
        Node next;
        Node(){
            this.next=null;
        }
        Node(int value){
            this.value=value;
            this.next=null;
        }
    }
    public void printNodes(Node node){
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }
    public Node addNode(int value){
        return new Node(value);
    }
    @Test
    public void test(){
        Node head= addNode(1);
        head.next=addNode(2);
        head.next.next=addNode(3);
        head.next.next.next=addNode(4);
        Node node = reverseNode(head);
        printNodes(node);
    }

    private Node reverseNode(Node node){
        Node current=node, next=null, prev=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
