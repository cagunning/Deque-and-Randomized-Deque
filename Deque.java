
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Deque<Item> implements Iterable<Item> {

    

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
        
        Item oldFirst = first;
        first = item;
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
        
        Item oldLast = last;
        last = item;
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
            Item oldFirst = first;
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
            Item oldLast = last;
            last = last.prev;
            if(last != null){
                last.next= null;
            }
            size--;
            return oldLast;
            

        }


    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator(){
        return new ItemIterator();
    }


    private class ItemIterator implements Iterator<Item> {
        private Item current = first;
        

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
                Item item = current;
                current = current.next;
                return item;
            }
        }
    }

    // unit testing (required)
    public static void main(String[] args){
        Deque<Item> dq = new Deque<Item>();
        dq.addFirst(new Item("hello"));
        dq.addLast(new Item("goodbye"));

        
       

        System.out.println(dq.isEmpty());
        System.out.println(dq.size());

        dq.removeFirst();
        System.out.println(dq);
        dq.addFirst(new Item("hi"));
        dq.addFirst(new Item("again"));

        dq.removeLast();
        System.out.println(dq);


        
        

    }
    

}