import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int elem = 0;
        String champ = "";
        while(!StdIn.isEmpty())
        {
            elem++;

            if (StdRandom.bernoulli((double) 1/elem)) {
                champ = StdIn.readString();
            }

        }

        StdOut.println(champ);
    }
}
