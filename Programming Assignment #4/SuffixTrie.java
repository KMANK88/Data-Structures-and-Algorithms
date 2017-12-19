import edu.princeton.cs.algs4.TrieST;



public class SuffixTrie {
    String s;
    TrieST<Integer> st = new TrieST<Integer>();
   
    public SuffixTrie(String LongString, String[] substrings){
        
    }
    
    public boolean SubstringReal (String LongString, String[] substring){
       boolean answer = true;
       int i=0;
       int j=0;
       int count =0;
       for( i=1; i< LongString.length(); i++){
           st.put(LongString.substring(i), i);
       } 
       
        for(j=0; j <substring.length; j++){
            
            
               for( String s : st.keys()){
                   if(s.startsWith(substring[j]) == true){
                    
                    System.out.println(substring[j] + " " + true + " " +  (st.get(s) +1));
                 // count++;
                  }else{
                    
                  }
                   
                   }
        }
        if(count == substring.length){
            System.out.println("all found in code");
        }else{
            System.out.println("The rest are not found in the code");
        }
    
        return answer;   
    }
    
    
    
    public static void main(String[] args) {

        In in = new In (args[0]);
        In in2 = new In (args[1]);
        
        String LongString = in.readLine();
        String substrings [] = in2.readAllLines();
        
     
        SuffixTrie ST = new SuffixTrie(LongString, substrings);
        
         ST.SubstringReal(LongString, substrings);
       
         
       }
}
     
    
    




