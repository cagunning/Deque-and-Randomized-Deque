import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    

    private int size = 0;
    private Node first = null;
    private Node last = null;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // construct an empty deque
    public Deque(){

    }

    // is the deque empty?
    public boolean isEmpty(){
        return this.size == 0;
        
    }

    // return the number of items on the deque
    public int size(){
        return size;
    }

    // add the item to the front
    public void addFirst( Item item){
        if(item == null){
            throw new IllegalArgumentException(" there is no item to add");
        }else{
        
        Node oldFirst = first;
        first = new Node();
        first.next = oldFirst;
        oldFirst.prev = first;
        size++;
        }
        
    }

    // add the item to the back
    public void addLast(Item item){
        if(item == null){
            throw new IllegalArgumentException("there is no item to add");
        }else{
        
        Node oldLast = last;
        last = new Node();
        last.prev = oldLast;
        oldLast.next = last;
        size++;
        }
    }

    // remove and return the item from the front
    public Item removeFirst(){
        if (first == null){
            throw new NoSuchElementException();
        }else{
            Item oldFirst = first.item;
            first = first.next;
            first.prev = null;
            size--;
            return oldFirst;
            

        }
        

    }

    // remove and return the item from the back
    public Item removeLast(){
        if (last == null){
            throw new NoSuchElementException();
        }else{
            Item oldLast = last.item;
            last = last.prev;
            if(last != null){
                last.next= null;
            }
            size--;
            return oldLast;
            

        }


    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new ItemIterator();
    }


    private class ItemIterator implements Iterator<Item> {
        private Node current = first;
        

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            } else {
                Item item = current.item;
                current = current.next;
                return item;
            }
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<String> dq = new Deque<String>();
        dq.addFirst("hello");
        dq.addLast("goodbye");

        
       

        System.out.println(dq.isEmpty());
        System.out.println(dq.size());

        dq.removeFirst();
        System.out.println(dq);
        dq.addFirst("hi");
        dq.addFirst("again");

        dq.removeLast();
        System.out.println(dq);


        
        

    }
    

}
