package amazonQuestions;

import org.junit.Test;

public class P12_RotateList {
    /*
    Given the head of a linked list, rotate the list to the right by k places.
    Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    Input: head = [0,1,2], k = 4
    Output: [2,0,1]
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
    /*
    - initialize new nodes head, next and prev
    - assign input node to the head.next
    - calculate the length of the list
    - find the length-n%length th node to rotate
    - finally swap
     */
    private Node rotateList(Node n, int k){
        Node head=new Node();
        head.next=n;
        Node fast=head, slow=head;
        int length=0;
        while(fast.next!=null){
            length++;
            fast=fast.next;
        }
        for (int i=length-k%length;i>0;i--) {
            slow = slow.next;
        }
            fast.next=head.next;
            head.next=slow.next;
            slow.next=null;

        return head.next;
    }
    @Test
    public void test1(){
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);
        Node node = rotateList(head, 2);
        printNodes(node);
    }
}
