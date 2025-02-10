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
    private Node priority;
    private int length;
    private int highScore;

    public PQList(){
        this.head = null;
        this.tail = null;
        this.length = 0;
        this.priority = null;
        this.highScore = 0;
    }

    public PQList(Node node){
        this.head = node;
        this.tail = node;
        this.length = 1;
        this.highScore = 0;
        this.priority = node;
        this.highScore = node.data.getScore();
    }

    @Override
    public void add(Player a) {
        Node node = new Node(a);
        if(this.highScore < node.data.getScore()){
            this.highScore = node.data.getScore();
            this.priority = node;
        }
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

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    @Override
    public boolean isEmpty() {
        if(this.length == 0)
            return true;
        return false;
    }
    private void searchHighScore(){
        this.highScore = 0;
        Node temp = this.head;
        for(int i = 0; i < this.length; i++){
            if (this.highScore < temp.data.getScore()){
                this.highScore = temp.data.getScore();
                priority = temp;
            }
            temp = temp.next;
        }
    }

    public Player getPriority(){
        return this.priority.data;
    }

    @Override
    public Player getHighestScorePlayer() {
        Node temp = this.head;
        while (temp != null){
            if (temp == this.priority){
                temp = this.priority;
                this.head = head.next;
                this.length -= 1;
                searchHighScore();
                return temp.data;
            }
            else if (temp.next == this.priority){
                temp.next = temp.next.next;
                temp = this.priority;
                this.length -= 1;
                searchHighScore();
                return temp.data;
            }
            temp = temp.next;
        }
        return null;
    }
}
