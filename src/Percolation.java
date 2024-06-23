import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int N;
    private final boolean[][] opened;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF uf_top;
    private final int virtual_top;
    private final int virtual_bottom;
    private int open_sites = 0;

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
        // without bottom virtual site
        uf_top = new WeightedQuickUnionUF(N*N+1);
        virtual_top = N * N;
        virtual_bottom = N * N + 1;

    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) throws IllegalArgumentException
    {
        if(row <= 0 || col <= 0 || row > N || col > N)
        {
            throw new IllegalArgumentException("N must be greater than 0 and lower than: " + N);
        }

        int current = (row - 1) * N + (col - 1);

        if(!opened[row-1][col-1])
        {
            open_sites++;
            opened[row-1][col-1] = true;

            if(row == 1)
            {
                uf.union(current, virtual_top);
                uf_top.union(current, virtual_top);
            } else if (row == N) {
                uf.union(current, virtual_bottom);
            }

            //[1; N]
            if(row > 1 && isOpen(row - 1, col))
            {
                //[0, N-1]
                uf.union(current, (row - 2) * N + (col - 1));
                uf_top.union(current, (row - 2) * N + (col - 1));
            }
            //[1; N]
            if(row < N && isOpen(row + 1, col))
            {
                //[0, N-1]
                uf.union(current, row * N + (col - 1));
                uf_top.union(current, row * N + (col - 1));
            }
            //[1; N]
            if(col > 1 && isOpen(row, col - 1))
            {
                //[0, N-1]
                uf.union(current, (row - 1) * N + (col - 2));
                uf_top.union(current, (row - 1) * N + (col - 2));
            }
            //[1; N]
            if(col < N && isOpen(row, col + 1))
            {
                //[0, N-1]
                uf.union(current, (row - 1) * N + col);
                uf_top.union(current, (row - 1) * N + col);
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
        return uf_top.find(virtual_top) == uf_top.find((row - 1) * N + (col-1));
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return open_sites;
    }
    // does the system percolate?
    public boolean percolates()
    {
        return uf.find(virtual_top) == uf.find(virtual_bottom);
    }

    public static void main(String[] args)
    {
//        int N = 20;
//        int sample_mean  = 0;
//
//        int opened_sites;
//        try {
//            Percolation p = new Percolation(N);
//            while(!p.percolates())
//            {
//                p.open(StdRandom.uniformInt(1, N + 1), StdRandom.uniformInt(1, N + 1));
//            }
//            opened_sites = p.numberOfOpenSites();
//            System.out.println(opened_sites);
//            System.out.println((double) opened_sites / (N * N));
//        }
//        catch (IllegalArgumentException e)
//        {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
    }
}

