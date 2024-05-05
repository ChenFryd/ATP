package algorithms.mazeGenerators;

public class EmptyMazeGenerator extends AMazeGenerator {
    @Override
    public Maze generate(int row, int col) {
        Maze res = new Maze(row, col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <col; j++) {
                res.changeCellValue(i,j,0);
            }
        }
        return res;
    }
}
