import java.util.Arrays;
import java.util.Random;

public class HashProbing {

   
       
    
    public void TestProbing(int N){
      Random myRand = new Random();
        int arraySize = N/2;
      int arr[] = new int[N]; 
      
      //System.out.println(arr.length);
      for(int i =0; i<arraySize; i++){
          int Y = myRand.nextInt();
          arr[i]=Y;
      }
     System.out.println(Arrays.toString(arr));
     
      for(int i=0; i<N; i++){
          if(arr[i] ==0){
              int X = myRand.nextInt();
              arr[i]=X;
          }
      }
    
    System.out.println(Arrays.toString(arr));
      
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Random rand = new Random();
        int N  = rand.nextInt(10)+1;
        HashProbing hp = new HashProbing();
        hp.TestProbing(N);
    }

}
