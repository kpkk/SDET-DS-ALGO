package twoPointer;

import org.junit.Test;

import java.util.ArrayList;

public class SwapNodesInLinkedList {
    /*
    1721. Swapping Nodes in a Linked List
    You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).



Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]
Example 3:

Input: head = [1], k = 1
Output: [1]
Example 4:

Input: head = [1,2], k = 1
Output: [2,1]
Example 5:

Input: head = [1,2,3], k = 2
Output: [1,2,3]


Constraints:

The number of nodes in the list is n.
1 <= k <= n <= 105
0 <= Node.val <= 100
     */
    public class Node{
        Node next;
        int value;
        public Node(){
        this.next=null;
        }
        public Node(int value){
            this.value=value;
            this.next=null;
        }

    }
    public void printAllNodes(Node head){
        while (head!=null){
            System.out.println(head.value);
            head=head.next;
        }
    }
    public Node addNode(int value){
        return new Node(value);
    }

    public Node swapNodes(Node node,int k){
        ArrayList<Integer>list=new ArrayList<>();
        while (node!=null){
            list.add(node.value);
            node=node.next;
        }
        int left=0, right=list.size()-1;
        while (left<=list.size() && right>=0){
            if(left==k-1&& list.size()-right==k){
                int temp=list.get(left);
                list.set(left,list.get(right));
                list.set(right,temp);
                break;
            }
            left++;
            right--;
        }
        Node head=new Node();
        Node tail=head;
        int i=0;
        while (i<list.size()){
            tail=addNode(list.get(i++));
            tail=tail.next;
        }
        return head.next;
    }

    @Test
    public void test1(){
        Node node=addNode(1);
        node.next=addNode(2);
        node.next.next=addNode(3);
        node.next.next.next=addNode(4);
        node.next.next.next.next=addNode(5);
        Node node1 = swapNodes(node, 2);
        printAllNodes(node1);
    }

}
