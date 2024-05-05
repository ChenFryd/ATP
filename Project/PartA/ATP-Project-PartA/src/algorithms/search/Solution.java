package algorithms.search;

import java.util.ArrayList;

/**
 * solution class
 * returns array with all solution steps
 */

public class Solution {

    private ArrayList<AState> solution;

    /**
     * constructor of solution
     */

    public Solution() {
        solution = new ArrayList<AState>();
    }


    /**
     * @param newState - add new state to solution
     */
    public void addState(AState newState) {
        if (newState != null)
            solution.add(newState);
    }

    /**
     * @return - return solution
     */
    public ArrayList<AState> getSolutionPath() {
        return solution;
    }
}