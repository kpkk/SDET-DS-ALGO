package dunZo;

import org.junit.Test;

import java.util.function.DoubleBinaryOperator;

public class DoublyLinkedList {
    public class Node {
        int value;
        Node next;
        Node prev;

        public Node(int value) {
            this.value = value;
        }
    }
        Node head,tail=null;
        public void addNode(int value){
            Node newNode=new Node(value);
            if(head==null){
                head=newNode;
                head.prev=null;
                tail=newNode;
                tail.next=null;
            }else{
                tail.next=newNode;
                newNode.prev=tail;
                tail=newNode;
                tail.next=null;
            }

        }
        public void printNodes(Node node){
            while (node!=null){
                System.out.println(node.value);
                node=node.next;
            }
        }
    @Test
    public void test1(){
        DoublyLinkedList node=new DoublyLinkedList();
        node.addNode(2);
        node.addNode(3);
        node.addNode(4);

    }

}
