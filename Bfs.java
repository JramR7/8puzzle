import java.util.*;

public class Bfs {
    Problem problem;
    TransitionModel transition = new TransitionModel();

    public Bfs(Problem problem) {
        this.problem = problem;
    }

    public ArrayList<String[]> search() {
        String initState = this.problem.initialState;
        NaryNode node = new NaryNode(initState, null, null, 0, 0, 0, 0, 0);
        Queue<NaryNode> frontier = new LinkedList<>(); 
        Set<String> explored = new HashSet<>(); 
        ArrayList<String[]> solution = new ArrayList<String[]>();

        if (problem.testGoal(node.state)) {
            solution = node.getSolution(node);
            return solution;
        }
        frontier.add(node);
    
        while (!(frontier.isEmpty())) {
            node = frontier.remove();
            explored.add(node.state);

            for (String action : problem.actions) {
                String actionState = transition.runAction(node.state, action);

                if (actionState != null) {
                    NaryNode child = new NaryNode(actionState, node, action, 0, 0, 0, 0, 0);

                    if (!explored.contains(child.state)) {
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