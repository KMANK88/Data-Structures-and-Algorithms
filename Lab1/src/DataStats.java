
public class DataStats {

    double mean;
    private double[] array;
    private int N;
    private int Size = 0;
    double totalNumber = 0;

    public DataStats(int N) {
        this.N = N;
        array = new double[N];
    }

    public double mean() {
        
        for (int i = 0; i < Size; i++) {
            totalNumber = (array[i] + totalNumber);
        }
        mean = totalNumber / Size;
        return mean;

    }

    public void append(double in) {

        if (Size > N) {
            throw new IndexOutOfBoundsException("To Many numbers");
        }
        array[Size] = in; //Grabbing the value in the other class and adding it to the array in this class
        Size++;

    }
}
