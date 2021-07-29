package week4;

import org.junit.Test;

public class LinkedList {

    /*

    LinkedList :  1 -> 3 -> 5
LinkedList :  2 -> 4 -> 6
Sorted LinkedList -> Merge Both LinkedList -> Return the sorted Linked List !!
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


    /*
    Solution:-

    - Initialize two nodes from two linked list objects and a next node as null
    - as long as the none of the nodes meets null value at node
        - compare the node values from both the list objects
            - which ever is small we add a new node with that node value and move to next
     -

     */
    public Node mergeNodes(Node n1, Node n2) {
        Node node=new Node();
        Node current=node;
        while (n1!=null && n2!=null){
            if(n1.value<n2.value){
                current.next= n1;
                n1=n1.next;
            }else{
                current.next=n2;
                n2=n2.next;
            }
            current=current.next;
        }
        current.next=n1==null?n2:n1;



        return node.next;
    }

    private Node mergeNodesUsingRecursion(Node n1, Node n2){
        if(n1==null)
            return n2;
        if(n2==null)
            return n1;
        if(n1.value<n2.value){
            n1.next=mergeNodesUsingRecursion(n1.next,n2);
            return n1;
        }else{
            n2.next=mergeNodesUsingRecursion(n1,n2.next);
            return n2;
        }

    }



        @Test
        public void test() {
            Node head1 = addNode(1);
            head1.next = addNode(3);
            head1.next.next = addNode(5);
            Node head2 = addNode(2);
            head2.next = addNode(4);
            head2.next.next = addNode(6);
            Node nodes = mergeNodesUsingRecursion(head1, head2);
            printAllNodes(nodes);

        }

    }

