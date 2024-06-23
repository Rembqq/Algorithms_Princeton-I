import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double mean;
    private final double stddev;
    private final double confidenceLow;
    private final double confidenceHigh;
    public PercolationStats(int n, int trials)
    {
        if(n <= 0 || trials <= 0)
        {
            throw new IllegalArgumentException("N and T have to be > 0");
        }

        Percolation[] p1 = new Percolation[trials];
        double[] open_sites_thresholds = new double[trials];


        for(int i = 0; i < trials; ++i)
        {
            p1[i] = new Percolation(n);
            while(!p1[i].percolates())
            {
                p1[i].open(StdRandom.uniformInt(1, n + 1), StdRandom.uniformInt(1, n + 1));
            }
            open_sites_thresholds[i] = (double) p1[i].numberOfOpenSites() / (n * n);
        }
        mean = StdStats.mean(open_sites_thresholds);
        stddev = StdStats.stddev(open_sites_thresholds);
        confidenceLow = mean - ((1.96 * stddev) / Math.sqrt(trials));
        confidenceHigh = mean + ((1.96 * stddev) / Math.sqrt(trials));
    }

    // sample mean of percolation threshold
    public double mean()
    {
        return mean;
    }

    // sample standard deviation of percolation threshold
    public double stddev()
    {
        return stddev;
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo()
    {
        return confidenceLow;
    }
    // high endpoint of 95% confidence interval
    public double confidenceHi()
    {
        return confidenceHigh;
    }
    // test client (see below)
    public static void main(String[] args)
    {
        try {
            PercolationStats PS = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
            System.out.println("mean                    = " + PS.mean());
            System.out.println("Standard deviation      = " + PS.stddev());
            System.out.println("95% confidence interval = [" + PS.confidenceLo() + ", " + PS.confidenceHi() + "]");

        } catch (IllegalArgumentException e)
        {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
