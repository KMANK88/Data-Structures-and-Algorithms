import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.LinearProbingHashST;


public class CompareTwoArrays
{

    private static boolean compareWithHeap (In inA, In inB, int size) {
        
        boolean match = true;
        Integer A [] =  new Integer[size];
        Integer B [] = new Integer[size];
        int counter = 0;

        
        
        while (!inA.isEmpty()) {
            int item = inA.readInt();
            A[counter] = item;
            counter++;

        }
        
        Heap.sort(A); 
        counter =0;
       
        while (!inB.isEmpty()) {
            int item = inB.readInt();
            B[counter] = item;
            counter++;

        }
        Heap.sort(B);
        
        for(int i =0; i<A.length; i++){
            if(A[i]!=B[i]){
                match = false;
                break;
            }
        }    
        return match;
    }
    
    private static boolean compareWithHash (In inA, In inB,int size) {
        LinearProbingHashST<Integer,Integer>  Hash = new LinearProbingHashST<Integer,Integer>();
        boolean match = true;
        int key =0;
        int value = 0;
        Integer A [] =  new Integer[size];
       
        while (!inA.isEmpty()) {
            int item = inA.readInt();
            key = item;
            
          if(Hash.get(key) != null){
              Hash.put(key, Hash.get(key)+1);
          }else{
              Hash.put(key, 1);
          }
            
           Hash.get(key);
           Hash.put(key, value);
        }
        
        
        for(int i =0; i< size; i++ ){
            int item = inB.readInt();
            key = item;
            if(Hash.get(key)!= null){
                if(Hash.get(key)>=1){
                   Hash.put(key, Hash.get(key)-1);
                }else{
                    Hash.put(key, null);
                }
            }else{
                match = false;
                break;
            }
        }
        
        
        return match;
    }
    
    public static void main(String[] args) {
        
        if (args.length < 3) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        String filenameA = args[0];
        String filenameB = args[1];
        String method    = args[2];
        
        if ( !method.equals("heap") && !method.equals("hash") ) {
            StdOut.println("Usage: java-algs4 CompareTwoArrays filenameA filenameB [heap/hash]");
            System.exit(1);
        }
        
        In inA = new In(filenameA);
        int nA = inA.readInt();

        In inB = new In(filenameB);
        int nB = inB.readInt();

        if (nA != nB) {
            StdOut.println("Arrays are not the same size, so not equivalent");
            System.exit(0);
        }
        
        boolean match = false;
        
        StopwatchCPU sw = new StopwatchCPU();
        if (method.equals("heap")) {
            match = compareWithHeap(inA, inB, nA);
        } else {
            match = compareWithHash(inA, inB, nA);
        }
        
        
        double elapsed = sw.elapsedTime();
        
        
        StdOut.println("The two input arrays do " + (match?"":"not ") + "match" );
        StdOut.println("elapsed time: " + elapsed + " seconds");
        
    }

   
}

