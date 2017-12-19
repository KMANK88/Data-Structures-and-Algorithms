/******************************************************************************
 *  Name: Karsten Pease
 *
 *  Hours to complete assignment (optional):16
 *
 ******************************************************************************/

Programming Assignment 3: Autocomplete


/******************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that equals the search key.
 *****************************************************************************/
The firstIndex of method finds the first index of a key by looking at the middle element and how it compares to the search key. If the search key is the same or smaller than, the midpoint it becomes the max and the search continues until the first value in the index array is found. If the search key is bigger than the midpoint then the minimum value is changed to the midpoint and binary search continues. Once the minimum + 1 is = or greater than the max the binary search stops. Then my method checks to see if the min or max is = to the key and if so it returns 0, if there is no key or nothing was found it returns -1. 


/******************************************************************************
 *  What is the order of growth of the number of compares (in the
 *  worst case) that each of the operations in the Autocomplete
 *  data type make, as a function of the number of terms n and the
 *  number of matching terms m?
 *
 *  Recall that with order-of-growth notation, you should discard
 *  leading coefficients and lower-order terms, e.g., m^2 + m log n.
 *****************************************************************************/

constructor: ~m log n

allMatches(): ~ n + m log n

numberOfMatches(): ~ (N) + (N)




/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
1)In binarySearchDeluxe it does not separate items in the first part of the array.
Meaning that if the array is  {11,11,10,9,8,1,1}
the first index and last index of will both be 0 for 11. Some times in different parts of the array it will be the same numbers and others it will be the same index location. I think it has to do with the numbers in the array at that location. 
2) When testing though the console some times the results would get skipped over, but most would appear. 

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings or lectures, but do include
 *  any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *
 *  Also include any resources (including the web) that you may
 *  may have used in creating your design.
 *****************************************************************************/
1)I had to have help on understanding binary algorithms, https://www.youtube.com/watch?v=5xlIPT1FRcA
2)I had some help from Travis trying to get one of my files to read in correctly. 

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
 

/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
I thought this assignment was not that bad, once we discussed it in class. Before that class on Monday it was very difficult to grasp and I felt very lost. A lot of times on some of these programming assignments, when I start out I feel very intimidated by the problem and lost until I do some research about different components in the assignment. In this assignment I had to get some more information on Binary Search and comparators. 
  