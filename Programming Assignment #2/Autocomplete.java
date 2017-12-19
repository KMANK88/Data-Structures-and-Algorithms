/*==================================
 * Karsten Pease Autocomplete.java
 * 
 * Shows popular results form ones typed in.
 =================================*/

import edu.princeton.cs.algs4.MergeX;

public class Autocomplete {
    
    Term [] results;
 /*
  //* Testing    
  
    public static void main(String[] args) {
        int count = 0;
        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int N = in.readInt();
        Term[] terms = new Term[N];
        for (int i = 0; i < N; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print out the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
    */
    public Autocomplete(Term[] terms){
        if(terms == null){
            throw new NullPointerException();
        }
        results = terms;
        MergeX.sort(results); //Puts the array of results in order using ~nlogn time(faster than insertion sort)!
    
}
    public Term[] allMatches(String prefix){
        if(prefix == null){
            throw new NullPointerException();
        }//uses the first letter to compare in the word the "A" in apple
        Term inPlaceArray = new Term(prefix,0);//simplify a temporary array. 
        int start = BinarySearchDeluxe.firstIndexOf(results, inPlaceArray, Term.byPrefixOrder(prefix.length()));
        //start because the firstIndexOf 
        if(start == -1){ //if it is outside of the array put it in the new array first place.
            return new Term[0];
        }
        int finish = BinarySearchDeluxe.lastIndexOf(results, inPlaceArray, Term.byPrefixOrder(prefix.length()));
        Term[] matchTerms = new Term[finish - start +1];
        //same thing as above but lastIndexOf()
        for(int i =0; i < matchTerms.length; i++){
            matchTerms[i] = results[start ++];
        }
       MergeX.sort(matchTerms,Term.byReverseWeightOrder()); //Term.byReverseWeightOrder is the comparitor that Merge sort needs.
        
        return matchTerms;
    }
    
    public int numberOfMatches(String prefix){
        if(prefix == null){
            //empty is null just like above. 
            throw new NullPointerException();
        }
     int start =  BinarySearchDeluxe.firstIndexOf(results, new Term(prefix,0), Term.byPrefixOrder(prefix.length()));
     int finish =  BinarySearchDeluxe.lastIndexOf(results, new Term(prefix,0), Term.byPrefixOrder(prefix.length()));
     int answer = finish - start + 1;  
     //Numer of matches the last number of matches will take the array location and find the the matches from the last index to the first index 
     //ex: if there is 500 "the" it will find 499 -0 + 1 and get the answer.
     return answer;      
    }
    
}
