import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    public int N;
    public boolean[][] blocked;
    public boolean[][] opened;
    public boolean[][] full;

    public int[][] parent;
    public int open_sites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws IllegalArgumentException
    {
        if(n <= 0)
        {
            throw new IllegalArgumentException("N must be greater than 0");
        }
        N = n;

        blocked = new boolean[N][N];
        opened = new boolean[N][N];
        full = new boolean[N][N];
        parent = new int[N][N];

        for(int i = 1; i <= N; ++i)
        {
            for(int j = 1; j <= N; ++j)
            {
                blocked[i-1][j-1] = true;
                parent[i-1][i-1] = ;
            }
        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException
    {
        if(row <= 0 || col <= 0 || row > N || col > N)
        {
            throw new IllegalArgumentException("N must be greater than 0 and lower than: " + N);
        }
        if(!opened[row-1][col-1])
        {
            open_sites++;
            opened[row-1][col-1] = true;

            if(isOpen(row-1, col))
            {
                union(row-1, col);
            }
            if(isOpen(row, col-1))
            {
                union(row, col-1);
            }
            if(isOpen(row-1,col-2))
            {
                union(row-1, col-2);
            }
            if(isOpen(row-2,col-1))
            {
                union(row-2, col-1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        if(row <= 0 || col <= 0 || row > N || col > N)
        {
            throw new IllegalArgumentException("N must be greater than 0 and lower than: " + N);
        }
        return opened[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        if(row <= 0 || col <= 0 || row > N || col > N)
        {
            throw new IllegalArgumentException("N must be greater than 0 and lower than: " + N);
        }
        return full[row-1][col-1];
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return open_sites;
    }
    // does the system percolate?
    public boolean percolates()
    {
        return false;
    }

    public void union(int p, int q)
    {

    }

    public void find()
    {

    }

    public void root(int p, int q)
    {

    }

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightedQuickUnionUF
        int opened_sites;
        try {
            Percolation p = new Percolation(N);
            while(!p.percolates())
            {
                p.open(3,6);
            }
            opened_sites = p.numberOfOpenSites();
        }
        catch (IllegalArgumentException e)
        {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

