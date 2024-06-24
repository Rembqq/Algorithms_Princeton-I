import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final int n;
    private final boolean[][] opened;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufTop;
    private final int virtualTop;
    private final int virtualBottom;
    private int openSites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n)
    {
        if (n <= 0)
        {
            throw new IllegalArgumentException("n must be greater than 0");
        }
        this.n = n;
        opened = new boolean[n][n];
        uf = new WeightedQuickUnionUF(n*n+2);
        // without bottom virtual site
        ufTop = new WeightedQuickUnionUF(n*n+1);
        virtualTop = n * n;
        virtualBottom = n * n + 1;

    }

    private void validateIndices(int row, int col)
    {
        if (row <= 0 || col <= 0 || row > n || col > n)
        {
            throw new IllegalArgumentException("n must be greater than 0 and lower than: " + n);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col)
    {
        validateIndices(row, col);
        int current = (row - 1) * n + (col - 1);

        if (!opened[row-1][col-1])
        {
            openSites++;
            opened[row-1][col-1] = true;

            if (row == 1)
            {
                uf.union(current, virtualTop);
                ufTop.union(current, virtualTop);
            } else if (row == n) {
                uf.union(current, virtualBottom);
            }

            //[1; n]
            if (row > 1 && isOpen(row - 1, col))
            {
                //[0, n-1]
                uf.union(current, (row - 2) * n + (col - 1));
                ufTop.union(current, (row - 2) * n + (col - 1));
            }
            //[1; n]
            if (row < n && isOpen(row + 1, col))
            {
                //[0, n-1]
                uf.union(current, row * n + (col - 1));
                ufTop.union(current, row * n + (col - 1));
            }
            //[1; n]
            if (col > 1 && isOpen(row, col - 1))
            {
                //[0, n-1]
                uf.union(current, (row - 1) * n + (col - 2));
                ufTop.union(current, (row - 1) * n + (col - 2));
            }
            //[1; n]
            if (col < n && isOpen(row, col + 1))
            {
                //[0, n-1]
                uf.union(current, (row - 1) * n + col);
                ufTop.union(current, (row - 1) * n + col);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col)
    {
        validateIndices(row, col);
        return opened[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col)
    {
        validateIndices(row, col);
        return ufTop.find(virtualTop) == ufTop.find((row - 1) * n + (col-1));
    }

    // returns the number of open sites
    public int numberOfOpenSites()
    {
        return openSites;
    }
    // does the system percolate?
    public boolean percolates()
    {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    public static void main(String[] args)
    {
//        int n = 20;
//        int sample_mean  = 0;
//
//        int opened_sites;
//        try {
//            Percolation p = new Percolation(n);
//            while(!p.percolates())
//            {
//                p.open(StdRandom.uniformInt(1, n + 1), StdRandom.uniformInt(1, n + 1));
//            }
//            opened_sites = p.numberOfOpenSites();
//            System.out.println(opened_sites);
//            System.out.println((double) opened_sites / (n * n));
//        }
//        catch (IllegalArgumentException e)
//        {
//            System.err.println("Error: " + e.getMessage());
//            e.printStackTrace();
//        }
    }
}

