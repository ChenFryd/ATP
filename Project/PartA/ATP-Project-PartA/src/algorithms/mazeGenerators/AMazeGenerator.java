package algorithms.mazeGenerators;

public abstract class AMazeGenerator implements IMazeGenerator {
    @Override
    public Long measureAlgorithmTimeMillis(int row, int col) {
        long start_t = System.currentTimeMillis();
        generate(row, col);
        long end_t = System.currentTimeMillis();
        long res = end_t - start_t;
        return res;
    }
}
