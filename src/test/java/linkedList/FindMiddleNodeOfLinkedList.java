package linkedList;

import org.junit.Test;

public class FindMiddleNodeOfLinkedList {


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
            Node node = addNode(10);
            node.next=addNode(30);
            node.next.next=addNode(44);
            node.next.next.next=addNode(32);
            node.next.next.next.next=addNode(67);
            int value= findMiddleNode(node);
            System.out.println(value);
        }
        //10-> 30-> 44 -> 32 -> 67
        public int findMiddleNode(Node head){
            Node fast=head;
            Node slow=fast;
            while (fast!=null && fast.next!=null){
                fast=fast.next.next;
                slow=slow.next;
            }
            return slow.value;
        }



}
