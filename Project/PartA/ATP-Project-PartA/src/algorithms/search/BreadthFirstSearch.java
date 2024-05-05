package algorithms.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch extends ASearchingAlgorithm {

    /**
     * constructor
     */

    public BreadthFirstSearch() {
        super();
        this.name = "BreadthFirstSearch"; //name = BFS
        this.numberOfNodes = 0;

    }


    /**
     * @param dom - get dom to solve
     * @return
     */
    @Override
    public Solution solve(ISearchable dom) {
        if (dom == null)
            return null;
        dom.ResetVisit(); // set all visit to false
        Queue<AState> queSteps = new LinkedList<AState>(); // new link list to keep steps
        queSteps.add(dom.getStartState()); // add the 1st state to queue
        dom.changeVisitTrue(dom.getStartState());
        numberOfNodes++;
        return FindSol(queSteps, dom);
    }

    /**
     * FindSol function - to get solution
     *
     * @param queSteps - get queue with start state and start going over it
     * @return - solution to dom problem
     */

    private Solution FindSol(Queue<AState> queSteps, ISearchable dom) {
        if (queSteps == null)
            return null;
        Solution Solu; //new solution
        ArrayList<AState> neighbours;
        while (queSteps.size() != 0) { //as long as there are steps to do
            AState temp = queSteps.poll(); //get a state from queue
            if (dom.getGoalState().equals(temp)) { //if state equal to end state
                dom.setGoalState(temp); //set end state
                Solu = finalSolution(temp);
                dom.ResetVisit(); //reset visited fields
                return Solu; //return solution
            }
            neighbours = dom.getAllPossibleStates(temp);
            for (int i = 0; i < neighbours.size(); i++) {
                if (!dom.isVisited(neighbours.get(i))) {// new state found
                    numberOfNodes++;
                    dom.changeVisitTrue(neighbours.get(i));
                    neighbours.get(i).cameFrom = temp; //updates its parent
                    queSteps.add(neighbours.get(i));
                }
                if (neighbours.get(i).equals(dom.getGoalState())) {
                    neighbours.get(i).cameFrom = temp;
                    //dom.setGoalState(allN.get(i)); //set end state
                    Solu = finalSolution(neighbours.get(i)); //function to add the path inside solu Solution
                    dom.ResetVisit(); //reset visited fields
                    return Solu; //return solution
                }
            }
        }
        return null;
    }
}