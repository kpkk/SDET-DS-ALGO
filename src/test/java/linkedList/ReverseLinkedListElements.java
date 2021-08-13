package linkedList;

import org.junit.Test;

public class ReverseLinkedListElements {

    /*
    Given a linked list, print its reverse order
    Eg: input=[1,2,3,4], output:- 4->3->2->1
     */
    // design a node to implement the linked list
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
    public void printNodeValues(Node node){
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    @Test
    public void test1(){
        Node node = addNode(1);
        node.next=addNode(2);
        node.next.next=addNode(3);
        node.next.next.next=addNode(4);
        Node node1 = reverseNodes(node);
        printNodeValues(node1);
    }
    /*
    Solution:-
    In reverse node, we have to make the previous node as next node
    - Initialize nodes current=node, next=null, prev=null
    - while the node is not null
    - make next as current.next
    - current.next as previous
    - previous is current
    - current=next
     */
    private Node reverseNodes(Node node){
        Node current=node, next=null,prev=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }
}
