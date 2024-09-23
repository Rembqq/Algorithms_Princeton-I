import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        if(this == y) return true;
        if(!(y instanceof Board other)) return false;

//        if(this.tiles.length == ((Board)y).tiles.length) {
//            for(int i = 0; i < tiles.length; ++i) {
//                for(int j = 0; j < tiles.length; ++j) {
//                    if(tiles[i][j] != ((Board)y).tiles[i][j]) {
//                        return false;
//                    }
//                }
//            }
//        }

        return Arrays.deepEquals(this.tiles, other.tiles);
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {

        List<Board> neighbors = new ArrayList<>();
        int n = dimension();

        int blankTileRow = -1;
        int blankTileCol = -1;

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(tiles[i][j] == 0) {
                    blankTileRow = i;
                    blankTileCol = j;
                    break;
                }
            }
        }

        if(blankTileRow > 0) {
            int[][] tmpTiles = copyMatrix();
            swap(tmpTiles, blankTileRow, blankTileCol, blankTileRow - 1, blankTileCol);
            neighbors.add(new Board(tmpTiles));
        }
        if(blankTileRow < n - 1) {
            int[][] tmpTiles = copyMatrix();
            swap(tmpTiles, blankTileRow, blankTileCol, blankTileRow + 1, blankTileCol);
            neighbors.add(new Board(tmpTiles));
        }
        if(blankTileCol > 0) {
            int[][] tmpTiles = copyMatrix();
            swap(tmpTiles, blankTileRow, blankTileCol, blankTileRow, blankTileCol - 1);
            neighbors.add(new Board(tmpTiles));
        }
        if(blankTileCol < n - 1) {
            int[][] tmpTiles = copyMatrix();
            swap(tmpTiles, blankTileRow, blankTileCol, blankTileRow, blankTileCol + 1);
            neighbors.add(new Board(tmpTiles));
        }

        return neighbors;
    }

    private void swap(int[][] tmpTiles, int row1, int col1, int row2, int col2) {
        int tmp = tmpTiles[row1][col1];
        tmpTiles[row1][col1] = tmpTiles[row2][col2];
        tmpTiles[row2][col2] = tmp;
    }

    private int[][] copyMatrix() {
        int[][] tmpTiles = new int[tiles.length][];
        for(int i = 0; i < tmpTiles.length; ++i) {
            tmpTiles[i] = Arrays.copyOf(tiles[i], tiles.length);
        }
        return tmpTiles;
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
                // not (i * tiles.length + j + 1) as we need zero as blank elem
                tiles[i][j] = i * tiles.length + j;
            }

        }

        Board b1 = new Board(tiles);
    }
}
