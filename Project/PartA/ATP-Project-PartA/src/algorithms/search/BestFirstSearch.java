package algorithms.search;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class BestFirstSearch extends ASearchingAlgorithm {
    public BestFirstSearch() {
        super();
        this.name = "BestFirstSearch";
        this.numberOfNodes = 0;

    }

    /**
     * @param o1 - state 1 to compare
     * @param o2 - state 2 to compare
     * @return
     */
    private int compareA(AState o1, AState o2) {
        if (o1.getCost() > o2.getCost())
            return 1;
        if (o2.getCost() > o1.getCost())
            return -1;
        else
            return 0;

    }


    /**
     * @param dom - get dom to solve
     * @return solve with BestFirstSearch
     */
    @Override
    public Solution solve(ISearchable dom) {
        if (dom == null)
            return null;
        dom.ResetVisit(); // set all visit to false
        PriorityQueue<AState> queSteps = new PriorityQueue<AState>(this::compareA);
        queSteps.add(dom.getStartState()); // initate
        dom.changeVisitTrue(dom.getStartState());
        return FindSol(queSteps, dom);
    }


    /**
     * @param queSteps - queue of steps
     * @param dom - get dom to solve
     * @return
     */
    private Solution FindSol(PriorityQueue<AState> queSteps, ISearchable dom) {
        if (queSteps == null)
            return null;
        Solution Solu;
        ArrayList<AState> MyNeighbours;
        while (queSteps.size() != 0) {
            AState temp = queSteps.poll();
            if (dom.getGoalState().equals(temp)) {
                dom.setGoalState(temp);
                Solu = finalSolution(dom.getGoalState());
                dom.ResetVisit();
                return Solu;
            }
            MyNeighbours = dom.getAllPossibleStates(temp);
            for (int i = 0; i < MyNeighbours.size(); i++) {
                if (!dom.isVisited(MyNeighbours.get(i))) {
                    MyNeighbours.get(i).cameFrom = temp; //update
                    numberOfNodes++;
                    if (MyNeighbours.get(i).equals(dom.getGoalState())) {
                        dom.setGoalState(MyNeighbours.get(i)); //set end state
                        Solu = finalSolution(dom.getGoalState()); //function to add the path inside solu Solution
                        dom.ResetVisit(); //reset visited fields
                        return Solu; //return solution
                    }
                    dom.changeVisitTrue(MyNeighbours.get(i));
                    queSteps.add(MyNeighbours.get(i));

                }
            }
        }
        return null;
    }
}