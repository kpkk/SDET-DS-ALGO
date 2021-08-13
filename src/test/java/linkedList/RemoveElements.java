package linkedList;

import org.junit.Test;

public class RemoveElements {

    /*
    Given a linked list and a value remove all the nodes that matches the value
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
    public void printAllNodes(Node node){
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
        head.next.next.next=addNode(6);
        head.next.next.next.next=addNode(4);
        head.next.next.next.next.next=addNode(6);
        Node node = removeNodes(head,6);
        printAllNodes(node);
    }
    /*
    Solution:-
    - Create two new nodes
    - while the input node is not null
    - if the node value is matching the input value, move the node to next
    - else, assign the node to current.next
    - move the current , noe to next
    - make the current.next node null

     */
    private Node removeNodes(Node node, int value){
       Node n=new Node();
       Node current=n;
       while (node!=null){
           if(node.value==value) node=node.next;
           else{
               current.next=node;
               current=current.next;
               node=node.next;
               current.next=null;
           }
       }
       return n.next;
    }
}
