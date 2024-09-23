import edu.princeton.cs.algs4.StdRandom;

public class Board {

    int[][] tiles;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        this.tiles = tiles;
        StdRandom.shuffle(this.tiles);
        for(int i = 0; i < this.tiles.length; ++i) {
            for(int j = 0; j < this.tiles.length; ++j) {
                System.out.println(this.tiles[i][j]);
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder boardRepresentation = new StringBuilder();

        boardRepresentation.append(tiles.length).append("\n");

        for(int i = 0; i < tiles.length; ++i) {
            for(int j = 0; j < tiles.length; ++j) {
                boardRepresentation.append(tiles[i][j]).append(" ");
            }
            boardRepresentation.append("\n");
        }

        return boardRepresentation.toString();
    }

    // board dimension n
    public int dimension() {
        return tiles.length;
    }

    // number of tiles out of place
    public int hamming() {
        int hammingDist = 0;
        for(int i = 0; i < tiles.length; ++i) {
            for(int j = 0; j < tiles.length; ++j) {
                // (i * tiles.length + j + 1) is current elem in [1,n] matrix
                if(tiles[i][j] == i * tiles.length + j + 1) { hammingDist++; }
            }
        }
        return hammingDist;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int manhattanSum = 0;
        int posValueDiff;
        int horizDiff, vertDiff;
        for(int i = 0; i < tiles.length; ++i) {
            for(int j = 0; j < tiles.length; ++j) {
                posValueDiff = Math.abs((i * tiles.length + j + 1) - tiles[i][j]);
                vertDiff = posValueDiff / tiles.length;
                horizDiff = posValueDiff % tiles.length;
                manhattanSum += vertDiff + horizDiff;
            }
        }
        return manhattanSum;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for(int i = 0; i < tiles.length; ++i) {
            for(int j = 0; j < tiles.length; ++j) {
                if((i * tiles.length + j + 1) != tiles[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        // TODO
        return false;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        // TODO
        return null;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        // TODO
        return null;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[][] tiles = new int[3][3];
        for(int i = 0; i < tiles.length; ++i) {
            for(int j = 0; j < tiles.length; ++j) {
                tiles[i][j] = i * tiles.length + j;
            }

        }

        Board b1 = new Board(tiles);
    }
}
