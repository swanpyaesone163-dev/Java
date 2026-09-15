public class DoublyLinkedList{
    
    Node head;
    Node tail;

    public class Node{
        int data;
        Node prev;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public void TraverseForward(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void TraverseBackward(){
    Node current = tail;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.prev;
        }
    }

    public void insertAtBeginning(int data){
        Node temp = new Node(data);
        if(head == null){
            head = temp;
            tail = temp;
        }
        else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }

    public void insertAtPosition(int data, int position){
        if(position == 1){
            insertAtBeginning(data);
            return;
        }

        int currentPosition = 1;
        Node current = head;

        while(current.next != null && currentPosition < position){
            current = current.next;
            currentPosition++;
        }
        if(curent == null){
            insertAtEnd(data);
            return;
        }

        Node temp = new Node(data)
        temp.next = current;
        temp.prev = current.prev;
        current.prev.next = temp;
        current.prev = temp;
    }

    public void insertAtEnd(int data){
        Node temp = new Node(data);
        if(tail == null){
            head = temp;
            tail = temp;
        }
        else{
            temp.prev = tail;
            tail.next = temp;
            tail = temp;
        }
    }

    public void deleteAtFront(){
        if(head == null){
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        Node temp = head.next;
    
        head.next = null;
        temp.prev = null;
        head = temp;
    }
}