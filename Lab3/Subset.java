
public class Subset {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int k = Integer.parseInt(args[0]);
       
        RandomizedBag<String> rand = new RandomizedBag<String>();
        
        while(!StdIn.isEmpty()){
            rand.put(StdIn.readString());
        }
        for(int i = 0; i<k; i++){
            System.out.println(rand.get());
           
        }
    }

}
