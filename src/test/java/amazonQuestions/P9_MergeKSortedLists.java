package amazonQuestions;

import org.junit.Test;

public class P9_MergeKSortedLists {
   /*
   You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.



Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []


Constraints:

k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] is sorted in ascending order.
The sum of lists[i].length won't exceed 10^4.
    */
    public class Node{
        int value;
        Node next;
        Node(){
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
    @Test
    public void test1(){
        Node node1=addNode(1);
        node1.next=addNode(3);
        node1.next.next=addNode(5);
        Node node2=addNode(2);
        node2.next=addNode(4);
        node2.next.next=addNode(6);
        Node node = mergeNodes(node1, node2);
        printNodes(node);
    }
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
        return head.next;
    }
}
