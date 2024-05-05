package algorithms.mazeGenerators;

public interface IMazeGenerator {
    public Maze generate(int row , int col);
    public Long measureAlgorithmTimeMillis( int row , int col);
}
