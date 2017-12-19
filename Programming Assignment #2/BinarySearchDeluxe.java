/*==================================
 * Karsten Pease BinarySearchDeluxe.java
 * 
 * Uses comparator for first and last index of items. 
 =================================*/

import java.util.Comparator;

public class BinarySearchDeluxe {
/*
    public static void main(String[] args) {
        Integer[] numbers = {98,95,93,24,22,11,11,10,9,4,4,3,1,1};
        Integer[] num = {1,1,2,2,2,3,3,3,4,4};
        Binary serch methods must be in order. 
    }
*/
    
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator <Key> comparator){
        if(a == null){
           throw new NullPointerException();
       }else if(key == null){
           throw new NullPointerException();
       }else if(comparator == null){
           throw new NullPointerException();
       }
        if(a.length == 0){
            return -1;// if the array has only one element return -1, nothing to compare later on. 
        }
        
        int min = 0;//starting point in array. 
        int max = a.length -1;// -1 because array leghth does not start at 0;
    
      
       
       while (min +1 < max){
           //simple binary search that goes through until we found our number. 
           int midpoint = (min + ((max -min)/2));//formula to find middle of something. 
           //must put middle in the while loop so that the values change every time we call it. 
           if(comparator.compare(key, a[midpoint]) <= 0){ 
               max = midpoint;//if the key and middle point in array is less than or = 0 the top point will be the middle. 
           }else if(comparator.compare(key, a[midpoint]) > 0) {
               min = midpoint;// if key and middle part of array are bigger than 0, the bottom point is middle. 
           }
       }
       //if the key and the bottom or top are the same return 0.
       if(comparator.compare(key, a[min]) == 0){
           return min;
          
       }
       if(comparator.compare(key,  a[max]) == 0){
           return max;
       }
       //if nothing was caught above return -1. aka key not in array.
        return -1;    
    }
    
    public static <Key> int lastIndexOf(Key [] a, Key key, Comparator <Key> comparator){
       // Almost a repeated method just reverse the compareto's.
        if(a == null){
            throw new NullPointerException();
        }else if(key == null){
            throw new NullPointerException();
        }else if(comparator == null){
            throw new NullPointerException();
        }
        if(a.length == 0){
            return -1;
        }
        
        int min = 0;
        int max = a.length-1;
        
         
         while (min +1 < max){
             int midpoint = (min + ((max -min)/2));
     
              if(comparator.compare(key, a[midpoint]) >= 0) {
                 min = midpoint;
             }    else if(comparator.compare(key, a[midpoint]) < 0){
                 max = midpoint;
                 
         }
         if(comparator.compare(key, a[max]) == 0){
             return max;
         }
         if(comparator.compare(key,  a[min]) == 0){
             return min;
         }   
        }
        return -1;  
    }
}
