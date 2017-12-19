import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.RedBlackBST;

public class CheckArraysForDuplicates
{
  
    
    public static void main(String[] args) {
        
        if (args.length < 1) {
            StdOut.println("Usage: java-algs4 CheckArraysForDuplicates filename");
            System.exit(1);
        }
        String filename = args[0];
        
        In in = new In(filename);
        
        int k = in.readInt(); // how many arrays
        int[] sizes = new int[k];  
        int[][] vals = new int[k][];  

        /* Read in all numbers into a set of arrays */
        for (int i=0; i<k; i++) {
            int n = in.readInt();
            sizes[i] = n;
            vals[i] = new int[n];
        }
        for (int i=0; i<k; i++) {
            for (int j=0; j < sizes[i]; j++) {
                vals[i][j] = in.readInt();
            }
        }
        
        
        
        /* Now it's your turn:  how to use a RedBlack tree (of size k) to solve this?*/
        boolean duplicate = true;
        StopwatchCPU sw = new StopwatchCPU();
        int G =0;
        int key = 0;

        RedBlackBST<Integer, Integer> rbt = new RedBlackBST<Integer, Integer>();
        int[] offsets = new int[k];
        for (int i=0; i<k; i++) {
            offsets[i] = 0;
            if(offsets[i] == vals[i][G]){
               duplicate = true;
            }else{
                duplicate = false;
                G++;
            }
           
            // anything here to check for duplicates?
            
            rbt.put(vals[i][0], i); 
           
            if(rbt.get(key) < rbt.get(key+1)){
                key ++;
                rbt.put(vals[key][0], key);
            }
            // use the array entry as the key, and the array index as the value
        }
            System.out.println(rbt.get(key));
       System.out.println(key);
          
        /* now what? */
       //now we want to put the smallest value onto a red black tree and if a new value is bigger take the smaller one out and put 
       //the new biggest value on it. 
         
            
        
        
        
        double elapsed = sw.elapsedTime();
        
        
        
        StdOut.println("The arrays do " + (duplicate?"":"not ") + "contain a duplicate " );
        StdOut.println("elapsed time: " + elapsed + " seconds");
        
    }

   
}

