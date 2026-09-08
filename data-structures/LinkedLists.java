import java.beans.JavaBean;
import java.util.*

public class LinkedLists{

    Node head;
    int count = 0;
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null; 
        }
    }

    public static LinkedLists InsertBack(Linkedlists list, int data){
        Node node_to_insert = new Node(data);
        node_to_insert.next = null;

        if(list.head == null){
            list.head = new_node;
            list.count += 1;
        }
        else{
            Node last = list.head;
            while(last.next != null){
                last = last.next;
            }
            last.next = node_to_insert;
            list.count += 1;
        }
    }

    public static LinkedLists InsertFront(Linkedlists list, int data){
        Node node_to_insert = new Node(data);
        node_to_insert.next = null;

        if(list.head == null){
            list.head = new_node;
            list.count += 1;
        }
        else{
            Node temp = list.head;
            list.head = new_node;
            new_node.next = temp;
            Node last = list.head;
            lists.count += 1;
        }
    }

    public static LinkedLists InsertAtPos(Linkedlists list, int data, int pos){
        Node node_to_insert = new Node(data);
        node_to_insert.next = null;

        if(pos > list.count){
            System.out.println("Index out of bounds!");
        }
        else{
            Node currNode = list.head; 
            for(int i = 1; i < pos; i++){
                currNode = currNode.next;
            }

        
        
        }
    }
    public static void main(String[] args){
        
    }
}