import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import java.lang.UnsupportedOperationException;
import java.util.NoSuchElementException;

public class RandomizedBag<Item> implements Iterable<Item>{
    Item[] a;
    int n;
    Random myRandom = new Random();
    
  
    public RandomizedBag(){
       a = (Item[]) new Object[2];
       n = 0;
      
    }
    
    public boolean isEmpty(){
       return n == 0;
    }
    
    public int size(){
       return n;
    }
    private void resize(int capacity) {
        assert capacity >= n;

        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
    
     public void put(Item item){
     if(item == null){
         throw new NullPointerException();
     }
    if(n == a.length) resize (2* a.length);
        a[n++] = item;
    }
    
    public Item get(){
     if(isEmpty()){
         throw new NoSuchElementException();
     }
      int info =  myRandom.nextInt(n);
      Item temp;
      temp =  a[info];
      a[info] = a[n-1];
       n--;
       //Getting random int of size n out of array and puttingit to an item
       // item is then made into the random location on the array
       //then that random spot in array is swiched with last part of array
       //--n decrements array size
        return temp;
        
    }
    
    public Item Sample(){ //returns random item but not removes (to remove its get);
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int info = myRandom.nextInt(n);
        Item sample;
        sample = a[info];
        return sample;
    }
    
    public Iterator<Item> iterator() {
        return new RandomArrayIterator();
    }
    private class RandomArrayIterator implements Iterator<Item> {
      
    Item [] b;
    int i;
    public RandomArrayIterator(){
       b = a;
      b = RandomizeArray(b);
      i = n-1;
    }

    public  Item[] RandomizeArray(Item[] array){
        
        Random rgen = new Random();  // Random number generator         
 
        for (int i=0; i<array.length; i++) {
            int randomPosition = rgen.nextInt(array.length);
            Item temp = array[i];
            array[i] = array[randomPosition];
            array[randomPosition] = temp;
        }
 
        return array;
    }
    
    public boolean hasNext() {        
        return i>=0;
    }

    public Item next() {
  if(!hasNext()) throw new NoSuchElementException();
        return b[i--];
    }
    public void remove(){
         throw new UnsupportedOperationException();
    }
   
    }}
    /*public static void main(String[] args) {
      RandomizedBag myBag = new RandomizedBag();
      
    

}*/
