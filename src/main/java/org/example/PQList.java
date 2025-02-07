package org.example;
public class PQList implements PriorityQueue {
    public class Node{
        private Player data;
        private Node next;
        public Node(Player p){
            data = p;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public PQList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public PQList(Node node){
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    @Override
    public void add(Player a) {
        Node node = new Node(a);
        if (this.head == null){
          this.head = node;
        }
        else{
            this.tail.next = node;
        }
        this.tail = node;
        this.length ++;
    }

    @Override
    public int getSize() {
        return this.length;
    }
}
