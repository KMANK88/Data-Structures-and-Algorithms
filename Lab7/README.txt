Karsten Pease
Lab7


4)The java client is, Reading in the file and using the first two elements as the number of vertices and edges in the graph. Then it creates a Depth First Search with a new graph.

then the for loop iterates through all 12 inputs and sets a boolean to if the path exists true= yes and false=no using the DFS .hasPathTo() method. it will print out if the input past has a a path to 10 , which was instantiated when the new DFDP was created and 10 was used as the source. 
If the path does not exists then it prints out no but if the path does exist. then it prints out yes and iterates through  the rest of the nodes that are between the selected one and 10 print them out and make a space. Do that until all values have gone through all the values. 

5)I was pretty close to what the code printed. It chose a long path because it was using a depth first search and what it needed to do was use breadth first search, because it is best with shortest path.

6)Debugging can help in recursive calls because you can see the values of and what steps your code is taking while it is processing. You can see the changes that are made during the recursive calls. 
	It prints out a longer version because we are using depth first search and should be using Breadth first search. 

7)It relates to the homework because We will need to find the shortest path in some scenarios and we will also need to find all the steps in a path to a certain solution. Which will require us to make the decision of BFS vs DFS and we need to know the importance of each of them and how they work.  