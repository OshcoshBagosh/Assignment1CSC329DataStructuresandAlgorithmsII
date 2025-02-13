package org.example;

/**
 * This class make a LinkedList that implements methods of a priority queue
 * @author Oscar Guerrero
 */
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
        this.priority = node;
        this.highScore = node.data.getScore();
    }

    public PQList(PQList other){
        if (other.isEmpty()){ // sets clone PQList empty if original PQList is empty
            this.head = null;
            this.tail = null;
            this.length = 0;
            this.priority = null;
            this.highScore = 0;
        }
        else{
            Node temp = other.head;
            while(temp != null) { // traverses through orginal PQList
                this.add(temp.data.createClone()); // adds player clones to PQList clone
                temp = temp.next;
            }
        }

    }

    /**
     *
     * @return clone of a PQlist
     */
    public PQList createClone(){
        PQList clone = new PQList(this);
        return clone;
    }

    /**
     * Adds a Player object to the priority queue
     * Checks if the Player has the highest score and gives them priority
     * increments length by 1
     *
     * @param p Player object to be added
     */
    @Override
    public void add(Player p) {
        Node node = new Node(p);
        if(this.highScore < node.data.getScore()){ //Checks if Player has the highest score
            this.highScore = node.data.getScore();
            this.priority = node;
        }
        if (this.head == null){ //checks if list is empty
          this.head = node;
        }
        else{
            this.tail.next = node;
        }
        this.tail = node; // sends player to the back of list (tail)
        this.length ++;
    }


    /**
     *
     * @return The length of the priority queue
     */
    @Override
    public int getSize() {
        return this.length;
    }

    /**
     * Sets the priority queue back to zero elements and length
     */
    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    /**
     * Checks if the priority queue is empty
     * @return True if length is 0 and false if not 0
     */
    @Override
    public boolean isEmpty() {
        if(this.length == 0)
            return true;
        return false;
    }

    /**
     * Traverses PQList and searches for player with the highest score
     */
    private void searchHighScore(){
        this.highScore = 0;
        Node temp = this.head;
        while (temp != null){
            if (this.highScore < temp.data.getScore()){
                this.highScore = temp.data.getScore();
                priority = temp;
            }
            temp = temp.next;
        }
    }

    /**
     * Traverses through PQList and removes the priority node by changing the previous node pointer
     * @return Highest score player
     */
    @Override
    public Player getHighestScorePlayer() {
        if (this.isEmpty())
            return null;
        Node temp = this.head; //starts with head of list
        if (temp == this.priority) { // If head contain priority player
            this.head = head.next; //Next node is head
            this.length -= 1;
            searchHighScore();
            return temp.data; // return head.
        }

        while (temp != null){ //traverse through list
            if (temp.next == this.priority){ //locates node before priority
                temp.next = temp.next.next; //changes temp's pointer to node afer priority
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
