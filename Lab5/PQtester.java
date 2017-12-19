import java.util.Random;

import edu.princeton.cs.algs4.MaxPQ;

public class PQtester {
static int N;
static MaxPQ maxpq = new MaxPQ();
Random myRanodm;
int L;
int fillInt;
    public static void main(String[] args) {
        // TODO Auto-generated method stub
       
        N = Integer.parseInt(args[0]);
        PQtester myPQ = new PQtester(N);
        double start = System.nanoTime();
       myPQ.insertKeys(N);
       myPQ.removeHalf(N);
       myPQ.fillUp(N);
       myPQ.removeAll(N);
       double end = System.nanoTime();
       double runTime = end - start;
       System.out.println(runTime);
       
       
    }
   public PQtester(int N){
      
       this.N = N;
       myRanodm = new Random();
       L=  myRanodm.nextInt(1000)+1;
   }
   public void insertKeys(int n){
       this.N = n;
       
       for(int i =0; i< n; i++){
           maxpq.insert(L);
       }
       System.out.println(maxpq.size());
   }
   public void removeHalf(int n){
       this.N =n;
       for(int i=0; i< n/2;i++){
           maxpq.delMax();
       }
       fillInt = n - maxpq.size();
       System.out.println(maxpq.size());
   }
   public void removeAll(int n){
       this.N =n;
       for(int i=0; i< n;i++){
           maxpq.delMax();
       }
       System.out.println(maxpq.size());
   }
   
   public void fillUp(int n){
       this.N =n;
       for(int i=0; i < fillInt; i++){
           maxpq.insert(L);
       }
       System.out.println(maxpq.size());
   }
   

}
