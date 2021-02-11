import java.util.*;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {

     // unit testing (required)
    public static void main(String[] args){
        RandomizedQueue<String> s = new RandomizedQueue<>();

        
        String str = "abc";
        String abc = "efg";

        s.enqueue(str);
        System.out.println(s.isEmpty());
        System.out.println(s.size());
        s.enqueue(abc);
        s.enqueue(abc);
        s.dequeue();
        System.out.println(s.sample());
        s.enqueue(abc);

        s.iterator();    

        
    }

    private Item[] items = (Item[]) new Object[50];
    private int size = 0;
    
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
            items[size] = item;
            size ++;
        }
    }

    // remove and return a random item
    public Item dequeue(){
        if(size == 0){
            throw new NoSuchElementException("can't dequeue if the queue is empty");
        }else{
            
            int i = StdRandom.uniform(size);
            Item copy = items[i];
            items[i] = items[size - 1];
            items[size - 1] = null;
            
            return copy;
        }
    }

    // return a random item (but do not remove it)
    public Item sample(){
        if(size == 0){
            throw new NoSuchElementException("can't dequeue if the queue is empty");
        }else{
            int i = StdRandom.uniform(size);
            return this.items[i];
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator(){
        return new ItemIterator();
        
    }

    private class ItemIterator implements Iterator<Item>{
        private int i;

        public boolean hasNext() {
            return items[i] != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = items[i++];
                return item;
            }
        }
    }

  

}


