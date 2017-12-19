/*========================================
 * Karsten Pease PercolationStatis.java
 *  Gets the stats of Percolaiton with random values and computes them.
 =======================================*/

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStatis {

    double mean;
    double stddev;
    double confidenceLow;
    double confidenceHigh;
    double[] formula;
    double blocksOpen;
    int gridSize;
    int count; // in the equation this would be T

    public static void main(String[] args) {

        int gridSize = Integer.parseInt(args[0]);// Parses for the argument of N
        int experiments = Integer.parseInt(args[1]);// parses for the argumetnt
                                                    // of T

        PercolationStatis percStats = new PercolationStatis(gridSize, experiments);

        System.out.println("The mean of the Percolation Stats is " + percStats.mean());
        System.out.println("The stddev is " + percStats.stddev());
        System.out.println("The low confidence interval is " + percStats.confidenceLow());
        System.out.println("The high confidence interval is " + percStats.confidenceHigh());
    }

    public PercolationStatis(int N, int T) {
        Percolation Perc;
        count = T;
        gridSize = N;
        if (N <= 0) {
            throw new IllegalArgumentException("The Grid size needs to be bigger than this.");
        }
        if (T <= 0) {
            throw new IllegalArgumentException("Must be more than 0 experiments!");
        }
        formula = new double[count];// Formula needing decimals need it to be an
                                    // array of the number of experiments, & I
                                    // dont know why it made me put new.

        // need to do a for loop to go through Percolation until it percolates.

        for (int i = 0; i < count; i++) {
            Perc = new Percolation(N); // Must be in for loop for every time
            int row;
            int col;
            blocksOpen = 0
                    ;
            // If it does percolate then all of this is not needed.
         
            while (Perc.percolates() == false) { // while percolation is false
                                                 // the row gets a random value
                row = StdRandom.uniform(gridSize); // Later in percolation it
                                                   // Opens at a location for
                                                   // row and col
                col = StdRandom.uniform(gridSize);
                if (Perc.isOpen(row, col) == false) { // If a certain box is not
                                                      // open then it will open
                                                      // said box.
                    Perc.open(row, col);
                    blocksOpen++; // blocks count goes up for another site open.
                }
            }
            // If it was an int it would not have made calculations. (cassens
            // notes.) Must be a double.
            formula[i] = blocksOpen / (gridSize * gridSize);
            // open sites over total number of grid Sites.
        }
    }

    // ************************************************
    // All formulas are given on the assignment sheet.
    // ************************************************

    public double mean() {
        mean = StdStats.mean(formula);
        return mean;
    }

    public double stddev() {
        stddev = StdStats.stddev(formula);
        return stddev;
    }

    public double confidenceLow() {
        confidenceLow = mean() - ((1.96 * stddev()) / Math.sqrt(count));
        return confidenceLow;
    }

    public double confidenceHigh() {
        confidenceHigh = mean() + ((1.96 * stddev()) / Math.sqrt(count));
        return confidenceHigh;
    }

}
