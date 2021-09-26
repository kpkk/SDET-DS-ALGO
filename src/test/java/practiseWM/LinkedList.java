package practiseWM;

import org.junit.Test;

public class LinkedList {
    public class Node{
        int value;
        Node next;
        public  Node(){
            this.next=null;
        }
        public Node(int value){
            this.value=value;
            this.next=null;
        }
    }
    public void printNode(Node node){
        while (node!=null){
            System.out.println(node.value);
            node=node.next;
        }
    }
    public Node addNode(int value){
        return new Node(value);
    }

    public Node reverse(Node node){
        Node current=node, prev=null,next=null;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public Node groupNodes(Node node){
    Node odd=node, even=odd.next, newNode=even;
       while (even!=null && even.next!=null){
           odd.next=even.next;
           odd=odd.next;
           even.next=odd.next;
           even=even.next;
       }
       odd.next=newNode;
       return node;
    }

    public Node mergeNodes(Node n1, Node n2){
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
        while (n1!=null){
            current.next=n1;
            current=current.next;
            n1=n1.next;
        }
        while (n2!=null){
            current.next=n2;
            current=current.next;
            n2=n2.next;
        }
        return head;
    }

    @Test
    public void test2(){
        Node node=new Node(1);
        node.next=addNode(2);
        node.next.next=addNode(3);
        node.next.next.next=addNode(4);
        node.next.next.next.next=addNode(5);
        node.next.next.next.next.next=addNode(6);
        Node reverse = groupNodes(node);
        printNode(reverse);
    }

    @Test
    public void test1(){
        Node node=new Node(2);
        node.next=addNode(3);
        node.next.next=addNode(4);
        Node reverse = reverse(node);
        printNode(reverse);
    }
}
