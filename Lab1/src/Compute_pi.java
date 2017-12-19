import java.util.Random;

public class Compute_pi {
    Random myrandom = new Random();
    double x;
    double y;
    double inside;
    double pi;
   
    public double compute_Pi(int n) {
        inside = 0;
        for (int i = 0; i <= n; i++) {
            x = myrandom.nextDouble();
            y = myrandom.nextDouble();
            
            if ((Math.sqrt(x*x + y*y)) <1) {
                inside++;
            } 
                pi = ((4 * inside) / n);
            
        }
        return pi;
    }
         
}
