/******************************************************************************
 *  Name:Karsten Pease 
 *  NetID:  kp250105(if you mean 790 # mine is 790723170)  
 *  Precept:  
 *
 *  
 *
 *  
 * 
 *  Operating system: OS X 10.11.6
 *  Compiler: Clips (Mars V2)
 *  Text editor / IDE: TextEdit
 *
 *  Have you taken (part of) this course before: No
 *  Have you taken (part of) the Coursera course Algorithm, Part I: No
 *
 *  Hours to complete assignment (optional): about 18hrs
 *
 ******************************************************************************/

Programming Assignment 1: Percolation


/******************************************************************************
 *  Describe how you implemented Percolation.java. How did you check
 *  whether the system percolates?
 *****************************************************************************/
1)I implemented my project by creating 2 boxes outside of the array once called start(the starting point or start of water)
and finish. The program would percolate if start and finish would be connected. I used a method called get grid ID. When the values are passed from row and col 
I used a formula that would make up the number for a certain box number. From there my open method would union the boxes at a specific point if they were open and not outside of the array with the box at a certain point.
My count method would go up if the open method was not open (while inside the open method) and add one to it making sure that all boxes that open are a accounted for. 
2)I checked by using PercolationVisualizer and changing the arguments to a specific file while putting that file into the src of my project. 


/******************************************************************************
 *  Using Percolation with QuickFindUF.java,  fill in the table below such that 
 *  the N values are multiples of each other.

 *  Give a formula (using tilde notation) for the running time (in seconds) of 
 *  PercolationStats.java as a function of both N and T. Be sure to give both 
 *  the coefficient and exponent of the leading term. Your coefficients should 
 *  be based on empirical data and rounded to two significant digits, such as 
 *  5.3*10^-8 * N^5.0 T^1.5.
 *****************************************************************************/

(keep T constant)
T =2;

 N          time (seconds)
------------------------------
100		.051
200		.556
400		39.994
800		144.093
1600		21119.381


(keep N constant)
N=50

 T          time (seconds)
------------------------------
100		.071
200		.124
400		.165
800		.276
1600		.463


running time as a function of N and T:  ~ 
~N^4	N^4 T
/******************************************************************************
 *  Repeat the previous question, but use WeightedQuickUnionUF.java.
 *****************************************************************************/

(keep T constant)
T=1

 N          time (seconds)
------------------------------
100		0.015
200		0.042
400		0.078
800		0.229
1600		1.081


(keep N constant)
N=50	

 T          time (seconds)
------------------------------
100		.005
200		.104
400		.152
800		.202
1600		.382


running time as a function of N and T:  ~ 
~N^2 N^2 logN T

/**********************************************************************
 *  How much memory (in bytes) does a Percolation object (which uses
 *  WeightedQuickUnionUF.java) use to store an N-by-N grid? Use the
 *  64-bit memory cost model from Section 1.4 of the textbook and use
 *  tilde notation to simplify your answer. Briefly justify your
 *  answers.
 *
 *  Include the memory for all referenced objects (deep memory).
 **********************************************************************/
A percolation object uses about 352 bytes to store an NXN grid.
I got 192 bytes for just Percolation objects and estimating the amount of padding and variable space in each of them and with the Weighted Quick Union Find method is an additional  160 bytes. I know that is probably extremely under what the answer is,however I have no idea how to solve it. 


/******************************************************************************
 *  After reading the course collaboration policy, answer the
 *  following short quiz. This counts for a portion of your grade.
 *  Write down the answers in the space below.
 *****************************************************************************/
1.C
2.B
3.D

1. How much help can you give a fellow student taking COS 226?
(a) None. Only the preceptors and lab TAs can help.
(b) You can discuss ideas and concepts but students can get help
    debugging their code only from a preceptor, lab TA, or
    student who has already passed COS 226.
(c) You can help a student by discussing ideas, selecting data
    structures, and debugging their code.
(d) You can help a student by emailing him/her your code.

2. What are the rules when partnering?
 (a) You and your partner must both be present while writing code.
     But after that only one person needs to do the analysis.
 (b) You and your partner must both be present while writing code
     and during the analysis, but, after that, only one person
     needs to be present while submitting the code and the
     readme.
 (c) You and your partner must both be present while writing code,
     during the analysis, and while submitting the code and the
     readme. Failure to do so is a violation of the course
     collaboration policy.

3. For any programming assignment, I am permitted to use code that
   I found on a website other than the COS 226 or algs4 website
   (e.g., on GitHub or StackOverflow):
 (a) Only when the online code was written by a person who does not
     and did not go to Princeton.
 (b) Only when the online code implemented different assignment
     specifications than the ones I'm currently working on.
 (c) Always, because online code is available to everyone.
 (d) Never, because such websites are an impermissible "outside 
     source".
 
/******************************************************************************
 *  Known bugs / limitations.
 *****************************************************************************/
1)Sometimes the counter will be off for boxes opened. 
2) There is a backfill issue. 
3) the Numbers in stats seem a bit off. 


/******************************************************************************
 *  Describe whatever help (if any) that you received.
 *  Don't include readings, lectures, and precepts, but do
 *  include any help from people (including course staff, lab TAs,
 *  classmates, and friends) and attribute them by name.
 *****************************************************************************/
I received some help from James Stauder. He helped point me in the right
direction by saying some sides won’t be able to be connected like most will.
He also recommended using a method that I could call to throw all my errors, I called said method Errors();

/******************************************************************************
 *  Describe any serious problems you encountered.                    
 *****************************************************************************/
1)My first big issue was than I would always get sent out of the array with and out of index problem, 
I eventually renumbered my boxes on the grid ID and had this issue dissappear.
2)I could not get counter correct. made an if statement and fixed it. 
3)Rows would be off when connecting(second row would turn blue and not top row) Just had to change one of the lists on my Open row. 
4)I would have trouble connecting some boxes through union. 



/******************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 *****************************************************************************/
I learned a lot after several hours of hitting my head against a keyboard(but thats how we learn). 
The read me file was a little hard to understand with some of the questions on it.
My comments will create some wearied spaces on the field because I formatted it so it will be off a bit. Most of the comments are for me later on and I use some slang language. 
