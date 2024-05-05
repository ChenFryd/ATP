package algorithms.search;

import algorithms.mazeGenerators.Maze;
import algorithms.mazeGenerators.MyMazeGenerator;
import algorithms.search.BestFirstSearch;
import algorithms.search.SearchableMaze;
import algorithms.search.Solution;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestFirstSearchTest {
    private MyMazeGenerator test = new MyMazeGenerator();
    private BestFirstSearch bestFS = new BestFirstSearch();
    private Maze testMaze = test.generate(15, 15);

    @Test
    void solve() {
        Solution Soul = bestFS.solve(new SearchableMaze(testMaze)); //solve maze with bfs
        assertNotEquals(null, Soul); //make sure its not equal null
    }

    @Test
    void getName() {
        assertEquals("BestFirstSearch", bestFS.getName()); // make sure name is BestFirstSearch
    }

    @Test
    void getNumberOfNodesEvaluated() {
        assertEquals(0, bestFS.getNumberOfNodesEvaluated()); //make sure before run its 0
    }

}