import java.util.Iterator;
import java.util.NoSuchElementException;



public class Deque<Item> implements Iterable<Item> {
    int n;
    Node first;
    Node last;
    
    public Deque(){
      first = null;
      last = null;
      n = 0;
      
    }
    
    private class Node{
        Item item;
        Node next;
        Node previous;
    }
    
    public boolean isEmpty(){
      return first == null;  
    }
    
    public int size(){
        return n;
    }
    
    public void addFirst(Item item){
      if(item == null){
          throw new NullPointerException();
      }
       if(n ==0){
           first = new Node();
           first.item = item;
           last = first;        //if it was empty the new element will be the first and last.
       }else{
           Node X = first;  //creating a new node makes it have the elements of first
           first = new Node();  //setting first to the new node
           first.item = item;   // the first item is the one passed in
           first.next = X;      // the next item is the new X (*which was the old first)
           X.previous = first;  //double linked list gives it a route back to the first one. 
       }
       n++;
       //increment N after if statemts so no matter what when yo add first it is getting bigger. 
    }
    
    public void addLast(Item item){
        if(item == null){
            throw new NullPointerException();
        }
        Node X = new Node();
        X.item = item;
        if( last != null){
           X.previous = last;
            last.next = X;
        }if(first == null){
            first = last;
        }
        n++;
    }
    
    public Item removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Item item = first.item;
        if(n ==1){
            last = null;
            first = null;
        }else {
            first.next.previous = null;
            first = first.next;
        }
        n--;
        
        
        return item;
    }
    
    public Item removeLast(){
       if(isEmpty()){
           throw new NoSuchElementException();
       }
       Item item = last.item;
       if(last.previous == null){
           last = null;
           first = null;
       }else{
           last.previous.next = null;
           last = last.previous;
       }
    n--;
        return item;
        
    }
    private class RemakeList implements Iterator<Item> {
         Node current;
        public RemakeList(Node x) {
            current = x;
        }
        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            Item thing = current.item;
            current = current.next;
            
            return thing;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException();
        }
    }
  
    
    public Iterator<Item> iterator() {
        
        return new RemakeList(first);
    }
    /*
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    */
}
