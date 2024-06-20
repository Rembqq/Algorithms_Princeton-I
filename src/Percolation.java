import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    public int N;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws IllegalArgumentException
    {
        if(n <= 0)
        {
            throw new IllegalArgumentException("N must be greater than 0");
        }
        N = n;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException
    {
        if(row <= 0 || col <= 0 || row > N || col > N)
        {
            throw new IllegalArgumentException("N must be greater than 0 and lower than: " + N);
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        return false;
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return 0;
    }
    // does the system percolate?
    public boolean percolates()
    {
        return false;
    }

    public static void main(String[] args)
    {
        try {
            Percolation p = new Percolation(6);
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

