import java.util.*;

public class Dfs {
    Problem problem;
    TransitionModel transition = new TransitionModel();

    public Dfs(Problem problem) {
        this.problem = problem;
    }

    public String search() {
        String initState = this.problem.initialState;
        NaryNode node = new NaryNode(initState, null, null, 0, 0, 0);
        Stack<NaryNode> frontier = new Stack<>();
        Set<String> explored = new HashSet<>(); 

        if (problem.testGoal(node.state)) {
            return node.state;
        }
        frontier.push(node);
    
        while (!(frontier.isEmpty())) {
            node = frontier.pop();
            explored.add(node.state);

            System.out.println(node.state);
            for (String action : problem.actions) {
                String actionState = transition.runAction(node.state, action);

                if (actionState != null) {
                    NaryNode child = new NaryNode(actionState, node, action, 0, 0, 0);

                    if (!explored.contains(child.state)) {
                        frontier.push(child);

                        if (problem.testGoal(child.state)) {
                            return child.state;
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void main(String[] args) { 
        String initialState = "182043765";
        String goalState = "012345678";
        String[] actions = {"up", "down", "left", "right"};

        Problem p = new Problem(initialState, goalState, actions);
        Dfs dfs = new Dfs(p);

        long startTime = System.currentTimeMillis();
        System.out.println(dfs.search());
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration);
    } 
}