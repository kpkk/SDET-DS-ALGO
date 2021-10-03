package customImplementation;

import org.junit.Test;

public class LinkedList {
    public class Node {
        int value;
        Node next;
        Node prev;

        public Node() {
            this.next = null;
        }

        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head, tail;

    public void insert(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            head.prev = null;
            tail = node;
            tail.next = null;
        } else {
            node = tail.next;
            node.prev = tail;
            tail = node;
            tail.next = null;
        }
    }
    public Node addNode(int value){
        return new Node(value);
    }

    public void printNodes(Node node) {
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }
    }
    @Test
    public void test1(){
        Node node=addNode(5);
        node.next = addNode(12);
        node.next.next=addNode(6);
        printNodes(node);

      //  Node node1 = reverseNode(node);
       // printNodes(node1);
       // System.out.println(findMiddleNode(node1));
        Node node2 = removeElement(node,12);
        System.out.println("--------------");
        printNodes(node2);

    }
    public Node reverseNode(Node node){
        Node prev=null, next=null;
        Node current=node;
        while (current!=null){
            next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        return prev;
    }

    public int findMiddleNode(Node node){
        Node fast=node;
        Node slow=node;
        while (fast!=null && fast.next!=null){
            fast=node.next.next;
            slow=slow.next;
        }
        return slow.value;
    }
    public Node removeElement(Node node, int value){
        Node head=new Node();
        Node current=head;
        while (node!=null){
            if(node.value==value)
                node=node.next;
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
    public void test2() {
        Node node = addNode(1);
        node.next = addNode(2);
        node.next.next = addNode(3);
        node.next.next.next = addNode(4);
        node.next.next.next.next = addNode(5);
        node.next.next.next.next.next = addNode(6);
        Node node1 = groupNodes(node);
        printNodes(node1);
    }
    public Node groupNodes(Node node){
        Node odd=node, even=odd.next, evenHead=even;
        while (even!=null && even.next!=null){
            odd.next=even.next;
            odd=odd.next;
            even.next=odd.next;
            even=even.next;
        }
        odd.next=evenHead;

        return node;
    }

    @Test
    public void test3() {
        Node node1 = addNode(1);
        node1.next = addNode(3);
        node1.next.next = addNode(5);
        Node node2 = addNode(2);
        node2.next = addNode(4);
        node2.next.next = addNode(6);

        Node node = mergeNodes(node1, node2);
        printNodes(node);
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
        return head.next;
    }
}

