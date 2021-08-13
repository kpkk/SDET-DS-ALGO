package week4;

import org.junit.Test;

public class PrintOddEvenLinkedList {

    public class Node{
        int value;
        Node next;
        Node(){
            this.next=null;
        }
        Node(int value){
            this.value=value;
        }
    }
    public Node addNode(int value){
        return new Node(value);
    }
    public void printAllNode(Node node){
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }

    /*
    - Initialize Nodes--> odd, even and evenHead
    - While even and even.next is not null
        - connect the odd with the next odd index (odd.next=even.next)
        - Then move the odd to the next position (odd=odd.next)
        - Connect the even with next even value (even.next= odd.next)
        - then move the even index to the next (even=even.next)
     - connect the even head to the odd.next to merge both the nodes
     - return the node
     */

    //Time complexity- O(n)
    //Space complexity-O(1)

    public Node printOddEvenList(Node node){
        Node odd=node, even=node.next, evenHead=even;
        while (even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;
        return node;
    }

    public Node condense(Node head) {
        Node unique=head.next, dup=head;
        while(unique!=null){
            int data=dup.value;
            unique.next=dup;
            if(unique.value==data){
                unique.next=null;
                dup=dup.next;
            }
            unique=unique.next;
        }

        return unique.next;

    }

    @Test
    public void test(){
        Node head = addNode(1);
        head.next=addNode(4);
        head.next.next=addNode(3);
        head.next.next.next=addNode(6);
        head.next.next.next.next=addNode(5);
        Node node = printOddEvenList(head);
     //   Node condense = condense(head);
        printAllNode(node);

    }
}
