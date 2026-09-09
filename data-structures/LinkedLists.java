import java.beans.JavaBean;
import java.util.*;

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

    public void InsertBack(int data){
        Node node_to_insert = new Node(data);

        if(head == null){
            head = node_to_insert;
        }
        else{
            Node last = head;
            while(last.next != null){
                last = last.next;
            }
            last.next = node_to_insert;
        }
        count++;
    }

    public void InsertFront(int data){
        Node node_to_insert = new Node(data);

        node_to_insert.next = head;
        head = node_to_insert;

         count++;
    }

    public void InsertAtPos(int data, int pos){
        if(pos >  count || pos < 0){
            System.out.println("Index out of bounds!");
            return;
        }

        Node node_to_insert = new Node(data);

        if(pos == 0){
            node_to_insert.next =  head;
            head = node_to_insert;
            count++;
            return;
        }

        Node currNode =  head; 

        for(int i = 1; i < pos; i++){
            currNode = currNode.next;
        }

        Node temp = currNode.next;
        currNode.next = node_to_insert;
        node_to_insert.next = temp;
        count++;            
    }

    public void PrintList(){
        if( head == null){
            System.out.println("Linked list is empty!");
            return;
        }

        Node currNode =  head;
        while(currNode != null){
            System.out.print(currNode.data + " ");
            currNode = currNode.next;
        }
    }

    public static void main(String[] args){
        LinkedLists list = new LinkedLists();

        list.InsertFront(1);
        list.InsertBack(5);
        list.InsertBack(10);
        list.InsertAtPos(2, 2);
        list.InsertAtPos(3, 4);

        list.PrintList();
    }
}