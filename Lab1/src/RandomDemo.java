import java.util.Random;
public class RandomDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
       // Random random = new Random(1234567L);
        Random random = new Random();
        boolean a = random.nextBoolean();
        int b = random.nextInt();
        int c= random.nextInt(100);
        double d = random.nextDouble();
        double e = random.nextGaussian();
        StdOut.println(a);
        StdOut.println(b);
        StdOut.println(c);
        StdOut.println(d);
        StdOut.println(e);
    }

}
