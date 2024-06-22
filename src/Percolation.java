import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    public int N;
    public boolean[][] opened;
    public WeightedQuickUnionUF uf;
    public int virtual_top;
    public int virtual_bottom;
    public int open_sites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) throws IllegalArgumentException
    {
        if(n <= 0)
        {
            throw new IllegalArgumentException("N must be greater than 0");
        }
        N = n;
        opened = new boolean[N][N];
        uf = new WeightedQuickUnionUF(N*N+2);
        virtual_top = N * N;
        virtual_bottom = N * N + 1;

//        for(int i = 1; i <= N; ++i)
//        {
//            for(int j = 1; j <= N; ++j)
//            {
//                blocked[i-1][j-1] = true;
//            }
//        }

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException
    {
        if(row <= 0 || col <= 0 || row > N || col > N)
        {
            throw new IllegalArgumentException("N must be greater than 0 and lower than: " + N);
        }

        int current = (row - 1) * N + (col - 1);

        if(row == 1)
        {
            uf.union(current, virtual_top);
        } else if (row == N) {
            uf.union(current, virtual_bottom);
        }

        if(!opened[row-1][col-1])
        {
            open_sites++;
            opened[row-1][col-1] = true;

            //[1; N]
            if(row > 1 && isOpen(row - 1, col))
            {
                //[0, N-1]
                uf.union(current, (row - 2) * N + (col - 1));
            }
            //[1; N]
            if(row < N && isOpen(row + 1, col))
            {
                //[0, N-1]
                uf.union(current, row * N + (col - 1));
            }
            //[1; N]
            if(col > 1 && isOpen(row, col - 1))
            {
                //[0, N-1]
                uf.union(current, (row - 1) * N + (col - 2));
            }
            //[1; N]
            if(col < N && isOpen(row, col + 1))
            {
                //[0, N-1]
                uf.union(current, (row - 1) * N + col);
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

    public static void main(String[] args)
    {
        int N = StdIn.readInt();
        WeightedQuickUnionUF w1 = new WeightedQuickUnionUF(4);
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

