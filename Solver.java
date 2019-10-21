import java.util.*;

public class Solver {
    public void formatSolution(ArrayList<String[]> solution) {
        for (String[] step : solution) {
            System.out.println("Action:" + step[0]);
            
            char[] state = step[1].toCharArray();
            for (int i = 0; i < state.length; i++) {
                if(((i%3) == 0) && (i != 0)){
                    System.out.println();
                } 
                System.out.print(state[i]);
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        String initialState = "182043765";
        String goalState = "012345678";
        String[] actions = {"up", "down", "left", "right"};

        Problem p = new Problem(initialState, goalState, actions);
        Solver solver = new Solver();
        Astar astar = new Astar(p);
        Bfs bfs = new Bfs(p);
        Dfs dfs = new Dfs(p);

        long startTime = System.currentTimeMillis();
        ArrayList<String[]> solution = astar.search();
        //ArrayList<String[]> solution = bfs.search();
        //ArrayList<String[]> solution = dfs.search();
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        
        Collections.reverse(solution);
        solver.formatSolution(solution);
        System.out.println("Done in: " + duration + "ms");
    }
}