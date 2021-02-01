import java.util.*;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

     // unit testing (required)
     public static void main(String[] args){

    }

    private int size = 0;
    private Item first = null;
    private Item last = null;

    private static class Item {
        private Item next;
        private Item prev;
        private String data;
        public Item (String newData){
            this.data = newData;
        }

    }
    // construct an empty randomized queue
    public RandomizedQueue(){

    }

    // is the randomized queue empty?
    public boolean isEmpty(){
        return this.size == 0;
    }

    // return the number of items on the randomized queue
    public int size(){
        return size;
    }

    // add the item
    public void enqueue(Item item){
        if(item == null){
            throw new IllegalArgumentException("can't enqueue with a null item");
        }else{

        }
    }

    // remove and return a random item
    public Item dequeue(){
        if(size == 0){
            throw new NoSuchElementException("can't dequeue if the queue is empty");
        }else{

        }
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(size == 0){
            throw new NoSuchElementException("can't dequeue if the queue is empty");
        }else{

        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){

    }

   

}
