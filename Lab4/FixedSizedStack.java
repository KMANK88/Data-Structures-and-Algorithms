import java.util.Iterator;

public class FixedSizedStack <Item> implements Iterable<Item>{

    int n;    
    int max;
    Deque myDeque = new Deque();
   
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        FixedSizedStack fss = new FixedSizedStack(4);
        fss.push(1);
        System.out.println(fss.size());
        fss.push(2);
        System.out.println(fss.size());
        System.out.println(fss.pop(fss));
        System.out.println(fss.pop(fss));
        System.out.println(fss.size());
    }
    
    public FixedSizedStack(int c){
      max = c;
    }
    
    public boolean isEmpty(){
        if(n == 0){
            return true;
        }
        return false;
        
    }
    
    public int size(){
        return n;
    }
    
    public void push(Item item){
        myDeque.addFirst(item);
        if(myDeque.size() == max){
            myDeque.addLast(item);
        }
        n++;
    }
    
    public Item pop(Item item){       
       n--;
        return  (Item) myDeque.removeFirst();
        
    }
    public Iterator<Item> iterator(){
        return myDeque.iterator();
        
    }
}
