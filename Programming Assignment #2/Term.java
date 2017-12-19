/*==================================
 * Karsten Pease Term.java
 * 
 * Compares first couple of indexes of words 
 =================================*/


import java.util.Arrays;
import java.util.Comparator;
   
    
public class Term implements Comparable<Term> {
    String text;
    long legthofWord;
/*
    public static void main(String[] args) {
    Term[] terms = new Term[4];
    terms[0] = new Term("Becky",55);
    terms[1] = new Term("Paula", 52);
    terms[2]= new Term("Emily", 21);
    terms[3] = new Term("Halle", 22);
   
    Arrays.sort(terms);
    for(Term t : terms){
        System.out.println(t);
        }
    
    System.out.println("");
    Arrays.sort(terms,Term.byReverseWeightOrder());
    for(Term t: terms){
        System.out.println(t);
        }
    
    System.out.println("");
    Arrays.sort(terms,Term.byPrefixOrder(1));
    for(Term t: terms){
        System.out.println(t);
        }
    }
  */ 

   public Term(String query, long weight){
       text = query;
       legthofWord = weight;
       if(query == null){
           throw new NullPointerException();
       }
       if(weight < 0){
           throw new IllegalArgumentException();
       }
       
   }
   
  public static Comparator<Term> byReverseWeightOrder(){
    return new CompareReverseWeightOrder();  
  }
  public static class CompareReverseWeightOrder implements Comparator<Term>{

    @Override
    public int compare(Term a, Term b) {
        // TODO Auto-generated method stub
        int ComparatorValue = 0;
        if(a.legthofWord > b.legthofWord){
           ComparatorValue = -1;
        }else if (a.legthofWord == b.legthofWord){
            ComparatorValue = 0;
        }else if (a.legthofWord < b.legthofWord){
            ComparatorValue = 1;
        }
      return ComparatorValue;
    }
   
}
  public static Comparator<Term> byPrefixOrder(int r) {
      if (r < 0){
          throw new IllegalArgumentException();
      }
      return new comparatorPrefix(r);
  }

  private static class comparatorPrefix implements Comparator<Term> {
      int numberOfCharecters;
      
      private comparatorPrefix(int r) {
          numberOfCharecters = r;
      }

    @Override
    public int compare(Term a, Term b) {
        // TODO Auto-generated method stub
        String word1 = null;
        String word2 = null;
        if(a.text.length() < numberOfCharecters){
            word1 = a.text;
        }else if(a.text.length() >= numberOfCharecters){
            word1 = a.text.substring(0,numberOfCharecters);
        //the method finds out if the first terms word length is smaller than the # of characters
        // if it is bigger than if finds the first character in the word and compares it to the other words first letter. 
        }
        
        if(b.text.length() < numberOfCharecters){
            word2 = a.text;
        }else if( b.text.length() >=  numberOfCharecters){
            word2 = b.text.substring(0,numberOfCharecters);
            //the r is the first number of charecters in the word that is put into the compare method, substring grabs the first charecter. 
        }
        return word1.compareTo(word2) ;
    }
  }  
  public int compareTo(Term that) {
           return text.compareTo(that.text);
  }
  public String toString(){
    return legthofWord+ " " + text;
      
  }


   
}
