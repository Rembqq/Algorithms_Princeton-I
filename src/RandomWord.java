import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int elem = 0;
        String champ = null;
        String word;
        while(!StdIn.isEmpty())
        {
            elem++;
            word = StdIn.readString();

            if(StdRandom.bernoulli(1.0/elem))
            {
                champ = word;
            }
        }

        StdOut.println(champ);
    }
}
