package recursion;

import org.junit.Test;

public class RemoveEleFromLinkedList {

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

    private Node removeElements(Node node,int value){
        if (node==null) return null;
        node.next= removeElements(node.next,value);
        return node.value==value?node.next:node;
    }

    @Test
    public void test1(){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(6);
        head.next.next.next.next=new Node(4);
        head.next.next.next.next.next=new Node(5);
        head.next.next.next.next.next.next=new Node(6);

        Node node = removeElements(head, 6);
        printAllNodes(node);
    }
}
