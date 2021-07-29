package week4;

import org.junit.Test;

public class ReverseNodes {

    /*
    reverse the nodes of a linked list
     */
    public class Node {
        int value;
        Node next;
        Node() {
            this.next = null;
        }
        Node(int value) {
            this.value = value;

        }
    }

        public Node addNode(int value) {
            return new Node(value);
        }
        public void printAllNodes(Node node) {
            while (node != null) {
                System.out.println(node.value);
                node = node.next;
            }
        }
        /*
        initialize variables current=node(1,2,3,4), next=null, prev=null,
        Initially store the node (sent as parameter) into current
        while the current is not null
            - next= current.next --> next=(2,3,4)
            - current.next= prev  ---> current.next=null (only 2,3,4 will be set to null)
            - prev= current -->  prev will have value-1
            - current=next--> current (2,3,4)
        print prev

         */
        private Node printInreverseOrder(Node n) {
            Node current = n, prev = null, next = null;
            while (current!=null){
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            return prev;
        }
    @Test
    public void test() {
        Node head1 = addNode(1);
        head1.next = addNode(2);
        head1.next.next = addNode(3);
        head1.next.next.next = addNode(4);
        Node node = printInreverseOrder(head1);
        printAllNodes(node);

    }

    }

