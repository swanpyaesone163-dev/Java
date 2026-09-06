import java.util.LinkedList;

public class LinkedLists {
    Node head;

    static class Node{
        int data;
        Node next;

        Node(int d){
            data = d;
            next = null;
        }
    }

    public static LinkedLists insert(LinkedLists node, int data)
    {
        Node new_node = new Node(data);

        if(node.head == null){
            node.head = new_node;
        }
        else{
            Node last = node.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = new_node;
        }

        return node;
    }

    public static void printList(LinkedLists node){
        Node currNode = node.head;

        System.out.print("LinkedList: ");

        while(currNode != null){
            System.out.print(currNode.data + " ");

            currNode = currNode.next;
        }
    }

    public static void main(String[] args) {
        LinkedLists list = new LinkedLists();

        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);

        printList(list);
    }
}


