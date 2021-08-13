package linkedList;

import org.junit.Test;

public class GroupOddAndEvenNodes {

    /*
    Given linked list, print all odd node value together followed by even node values
    Eg: 1->2->3->4->5->6  output-  1->3->5->2->4->6
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
    public Node addNode(int value){
        return new Node(value);
    }
    public void printNodes(Node node){
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
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
        Node node = groupOddEvenNodes(head);
        printNodes(node);
    }
    public Node groupOddEvenNodes(Node node){
       Node odd=node, even=odd.next, newNode=even;
       while (even!=null&& even.next!=null){
           odd.next=even.next;
           odd=odd.next;
           even.next=odd.next;
           even=even.next;
       }
       odd.next=newNode;
       return node;
    }
}
