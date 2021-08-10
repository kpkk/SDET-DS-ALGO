package week6;

import org.junit.Test;
import week4.LinkedList;

public class RemoveLinkedListElements {

    /*

    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.



Example 1:


Input: head = [1,2,6,3,4,5,6], val = 6
Output: [1,2,3,4,5]
Example 2:

Input: head = [], val = 1
Output: []
Example 3:

Input: head = [7,7,7,7], val = 7
Output: []


Constraints:

The number of nodes in the list is in the range [0, 104].
1 <= Node.val <= 50
0 <= val <= 50
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
        Node head1 = addNode(1);
        head1.next = addNode(2);
        head1.next.next = addNode(6);
        head1.next.next.next=addNode(3);
        head1.next.next.next.next=addNode(4);
        head1.next.next.next.next.next=addNode(5);
        head1.next.next.next.next.next.next=addNode(6);
        Node node = recursion(head1, 6);
        printAllNodes(node);
    }

    private Node removeElements(Node n,int value){
        Node node=new Node();
        Node current=node;
        while (n!=null){
            if(n.value!=value) {
                current.next=n;
                current=current.next;
                n=n.next;
                current.next=null;

            }else{
                n=n.next;
            }
        }
        return node.next;
    }

    Node node=new Node();
    Node current=node;
    private Node recursion(Node n, int value){
        current.next=null;
        if(n==null) return node.next;
        if(n.value!=value){
            current.next=n;
            current=current.next;
        }
       return recursion(n.next,value);
    }

}

