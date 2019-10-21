import java.util.*;

class HeuristicComparator implements Comparator<NaryNode>{ 
    public int compare(NaryNode node1, NaryNode node2) { 
        if (node1.hn < node2.hn) 
            return 1; 
        else if (node1.hn > node2.hn) 
            return -1; 
        return 0; 
    } 
} 

public class Astar {
    Problem problem;
    TransitionModel transition = new TransitionModel();

    public Astar(Problem problem) {
        this.problem = problem;
    }

    public Double hammingDistance(String currState){
        double hn = 0.0;
        char[] goalState = problem.goalState.toCharArray();
        char[] curState = currState.toCharArray();

        for (int i = 0; i < 9; i++) {
            if (curState[i]!= goalState[i]) hn++;
        }
        return hn;
    }

    public Double f(String currState, Double cost){
        Double temp = 0.0;
        temp = hammingDistance(currState);
        return temp+cost;
    }

    public ArrayList<String[]> search() {
        String initState = this.problem.initialState;
        NaryNode node = new NaryNode(initState, null, null, 0, 0, 0, 0, 0);
        PriorityQueue<NaryNode> frontier = new PriorityQueue<NaryNode>(5, new HeuristicComparator());
        Set<String> explored = new HashSet<>(); 
        ArrayList<String[]> solution = new ArrayList<String[]>();

        if (problem.testGoal(node.state)) {
            solution = node.getSolution(node);
            return solution;
        }
        node.hn = f(node.state, node.gn);
        frontier.add(node);
    
        while (!(frontier.isEmpty())) {
            node = frontier.remove();
            explored.add(node.state);
            
            for (String action : problem.actions) {
                String actionState = transition.runAction(node.state, action);

                if (actionState != null) {
                    NaryNode child = new NaryNode(actionState, node, action, 0, 0, 0, node.gn + 1, 0);

                    if (!explored.contains(child.state)) {
                        child.hn = f(child.state, child.gn);
                        frontier.add(child);

                        if (problem.testGoal(child.state)) {
                            solution = child.getSolution(child);
                            return solution;
                        }
                    }
                }
            }
        }
        return null;
    }
}