
public class ComputePi {
String S;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Compute_pi math = new Compute_pi();
        int s = 0;
       for(String S : args)
          s = Integer.parseInt(S);
         
            
        System.out.println(math.compute_Pi(s));
    }

}
