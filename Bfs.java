import java.util.*;

public class Bfs {
    Problem problem;
    TransitionModel transition = new TransitionModel();

    public Bfs(Problem problem) {
        this.problem = problem;
    }

    public String search() {
        String initState = this.problem.initialState;
        NaryNode node = new NaryNode(initState, null, null, 0, 0, 0);
        Queue<NaryNode> frontier = new LinkedList<>(); 
        Set<String> explored = new HashSet<>(); 

        if (problem.testGoal(node.state)) {
            return node.state;
        }
        frontier.add(node);
    
        while (!(frontier.isEmpty())) {
            node = frontier.remove();
            explored.add(node.state);

            System.out.println(node.state);
            for (String action : problem.actions) {
                String actionState = transition.runAction(node.state, action);

                if (actionState != null) {
                    NaryNode child = new NaryNode(actionState, node, action, 0, 0, 0);

                    if (!explored.contains(child.state)) {
                        frontier.add(child);

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
        Bfs bfs = new Bfs(p);

        long startTime = System.currentTimeMillis();
        System.out.println(bfs.search());
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println(duration);
    } 
}