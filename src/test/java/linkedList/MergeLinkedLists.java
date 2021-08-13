package linkedList;

import org.junit.Test;

public class MergeLinkedLists {

    /*

    Given two linked lists, l1 and l2, merge them such that they are arranged in sorting order
    Eg: n1= 1->3->5 and n2=->2->4->6  output->  1->2->3->4->5->6
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
        Node n1=addNode(1);
        n1.next=addNode(3);
        n1.next.next=addNode(5);
        Node n2=addNode(2);
        n2.next=addNode(4);
        n2.next.next=addNode(6);
        Node node = mergeNodes(n1, n2);
        printAllNodes(node);
    }
    /*
    - Initialize two new nodes, head and current
    - while both the input nodes are not null
    - if the n1. value is less than n2 value
        - current.next=n1 and move both current and n1
    - else current.next=n2 and move both current and n2
    - if either of the input is not null, add those nodes to the current
    - return head.next

     */
    private Node mergeNodes(Node n1, Node n2){
        Node head=new Node();
        Node current=head;
        while (n1!=null && n2!=null){
            if(n1.value<n2.value){
                current.next=n1;
                current=current.next;
                n1=n1.next;
            }else{
                current.next=n2;
                current=current.next;
                n2=n2.next;
            }
        }
        while (n1!=null) {
            current.next=n1;
            current=current.next;
            n1=n1.next;
        }
        while (n2!=null) {
            current.next=n2;
            current=current.next;
            n2=n2.next;
        }
        return head.next;
    }
}
