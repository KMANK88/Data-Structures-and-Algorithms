/******************************************************************************
 *  Name: Karsten Pease     
 *
 *  Hours to complete assignment (optional): 9
 *
 ******************************************************************************/

Programming Assignment 3: WordNet


/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in synsets.txt. Why did you make this choice?
 *****************************************************************************/
I chose to put synsets in a Hash table with linear probing. 

I made two of the tables one for the ID  and the other for the actual word. The Strings would be used as a key for the Hash table and the ID would be put onto a queue so that we can continue to put elements into the queue and when we wanted a certain word we could just dequeue it and have the element that would be at the top (or bottom) of the wordNet. Than as we look for common ancestors we can remove the most recent one and eventually get to the closest ancestor. 

I did not choose a stack because It would not make sense to push elements on to a stack and pop them off one by one until we find the element we are looking for, a queue seemed much more reasonable.  

As for why I chose a Linear probing hash table, The slides provided to us in class lead me to go that way. 



/******************************************************************************
 *  Describe concisely the data structure(s) you used to store the 
 *  information in hypernyms.txt. Why did you make this choice?
 *****************************************************************************/
I stored the Hypernyms onto an undirected graph and then put those graph edges into the shortest Common Ancestor class, which was an undirected graph and a breadth first search method. 


/******************************************************************************
 *  Describe concisely the algorithm you use in the constructor of
 *  ShortestCommonAncestor to check if the digraph is a rooted DAG.
 *  What is the order of growth of the worst-case running times of
 *  your algorithms as a function of the number of vertices V and the
 *  number of edges E in the digraph?
 *****************************************************************************/

Description:I chose the breadth first path algorithm, because if we wanted to find the shortest common ancestor  between numbers.
This is the closest thing to breath first search i could find. 
 

Order of growth of running time:
V + E

/******************************************************************************
 *  Describe concisely your algorithm to compute the shortest common
 *  ancestor in ShortestCommonAncestor. For each method, what is the order of
 *  growth of the worst-case running time as a function of the number of
 *  vertices V and the number of edges E in the digraph? For each method,
 *  what is the order of growth of the best-case running time?
 *
 *  If you use hashing, you should assume the uniform hashing assumption
 *  so that put() and get() take constant time.
 *
 *  Be careful! If you use a BreadthFirstDirectedPaths object, don't
 *  forget to count the time needed to initialize the marked[],
 *  edgeTo[], and distTo[] arrays.
 *****************************************************************************/

Description:
I used BreadthFirstPath. Because the way it uses a queue to look at all the paths before making a chose seemed right for the situation. 
                                              running time
method                               best case            worst case
------------------------------------------------------------------------
length(int v, int w)			~ v + w			~v + w

ancestor(int v, int w)			~ V + W			~V + w

length(Iterable<Integer> v,		~ V + W			~V + W
       Iterable<Integer> w)

ancestor(Iterable<Integer> v,		~V + W			~V + W
         Iterable<Integer> w)

each method used the breadth first search method and its best and worst case runtime is V + W which takes up the most 
memory for the runtime. 



/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
Do not know if answered are off or not. 

/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
Jimmy helped me with the for each method with i ended up using a lot this time around, very helpful when trying to make for loops with Strings. 
I also had to look up on stack over flow what to store for the site in Shortest common ancestor, which ended up being Integer.MAX_VALUE;.


/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
I could not find the BreadthFirstSerch type in the lags 4 folder, after looking up online I found out that it is called BreadthFirstPaths. Hope that is the same thing. 