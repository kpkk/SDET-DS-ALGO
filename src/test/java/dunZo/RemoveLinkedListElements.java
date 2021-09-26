package dunZo;

import org.junit.Test;

public class RemoveLinkedListElements {
    /*
    Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

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
        public Node(){
            this.next=null;
        }
        public Node(int value){
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

    public Node removeElements(Node node, int value){
        Node head=node;
        Node current=head;
        while (node!=null){
            if(node.value==value){
                node=node.next;
            }
            else{
                current.next=node;
                current=current.next;
                node=node.next;
                current.next=null;
            }
        }
        return head.next;
    }
    @Test
    public void test1(){
        Node node = addNode(1);
        node.next=addNode(2);
        node.next.next=addNode(3);
        node.next.next.next=addNode(1);
        Node node1 = removeElements(node,1);
        printNodes(node1);

    }
}
