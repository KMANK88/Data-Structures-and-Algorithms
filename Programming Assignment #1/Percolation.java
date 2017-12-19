/*=================================================
 * Karsten Pease Percolation.java
 * Percolation, getting a grid and filling in boxes.
 ================================================*/

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    int gridSize;
    boolean[][] openSites;
    int start = 0;// 0 Because its ID in the array will start at 1
    int finish;
    WeightedQuickUnionUF WQUF;
    int count;

    // r is for rows and c is for columns***

    public Percolation(int N) {

        if (N <= 0) {
            throw new IllegalArgumentException("Grid is too small, make bigger");
        }
        // All sites need to be closed
        gridSize = N;
        openSites = new boolean[gridSize][gridSize]; // Automatically set to
                                                     // false
        finish = (gridSize * gridSize) + 1;
        WQUF = new WeightedQuickUnionUF(gridSize * gridSize + 2);

    }

    private void Errors(int r) {
        if (r < 0) {
            throw new IndexOutOfBoundsException("R is out of bounds put R inside of N.");
        }

    }

    private int getGridID(int r, int c) {
        int row = r + 1;
        int col = c + 1;
        int gridID = (gridSize * (row - 1) + col);
        return gridID;
        // it will take whatever the col is and take 1 away from the row while
        // multiplying the grid Size and getting whatever the ID, the +1 is so
        // no INDEX outof bounds error can occur.
        // Of the array is (start out with writing first array box = 1
        // While finish will be how big the grid is (N^2) +1; One past the final
        // ID
    }

    public void open(int r, int c) {
        Errors(r);

        if (!isOpen(r, c)) {
            count++;
        }
        openSites[r][c] = true;// when it was closed it was false;

        // All of the following if statements will find their specific ID in the
        // grid
        // And check if there is a box that is open around above, below, left
        // and right of it
        // IF it is in those locations then it connects the current open site
        // with those around it.

        if (r == 0) {
            WQUF.union(start, getGridID(r, c)); // opens top of grid to start
        }

        if (r + 1 == gridSize) {
            WQUF.union(finish, getGridID(r, c)); // opens bottom of grid to
                                                 // finish
        }

        if (c != 0) {
            if (c > 0 && isOpen(r, c - 1)) {
                WQUF.union(getGridID(r, c), getGridID(r, c - 1));
                // connects the column to the block ABOVE it if it is open
            }
        }

        if (r != 0) {
            if (r > 0 && isOpen(r - 1, c)) {
                WQUF.union(getGridID(r, c), getGridID(r - 1, c));
                // connects current block with block to the LEFT
            }
        }

        if (r + 1 != gridSize) {
            if (r < gridSize && isOpen(r + 1, c)) {
                WQUF.union(getGridID(r, c), getGridID(r + 1, c));// right
                // Connects current block with block to RIGHT
            }
        }

        if (c + 1 != gridSize) {
            if (c < gridSize && isOpen(r, c + 1)) {
                WQUF.union(getGridID(r, c), getGridID(r, c + 1));
                // connects to block that is BELOW current block
            }
        }

    }

    public boolean isOpen(int r, int c) {
        Errors(r);
        return openSites[r][c];
    }

    public int numberOfOpenSites() {
        return count;
    }

    public boolean isFull(int r, int c) {
        Errors(r);
        if (r >= 0 && r < gridSize && c >= 0 && c < gridSize) {
            return WQUF.connected(start, getGridID(r, c));
        } else
            throw new IndexOutOfBoundsException();

        /*
         * The is Full method is checking if the spot is connected to the start
         * and to make sure that it is inside the grid. if it is connected to
         * the start then it is full and is true if it is not then it is false
         * and empty. and if it is not in the grid then it will throw an error
         */
    }

    public boolean percolates() {

        return WQUF.connected(start, finish);
    }
    /*
     * Static main method to use for testing. Ignore. public static void
     * main(String[] args) { Percolation perc = new Percolation("number"); }
     */
}
