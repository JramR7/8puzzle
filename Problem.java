public class Problem {
    String initialState;
    String goalState;
    String[] actions;

    public Problem(String initialState, String goalState, 
                    String[] actions) {
            
        this.initialState = initialState;
        this.goalState = goalState;
        this.actions = actions;
    }

    public boolean testGoal(String state) {
        boolean isGoal = (this.goalState.equals(state)) ? true : false;
        return isGoal;
    }

    /* Test the problem class
    public static void main(String[] args) { 
        String initialState = "123804765";
        String goalState = "012345678";
        String[] actions = {"up", "down", "left", "right"};

        Problem p = new Problem(initialState, goalState, actions);
        System.out.println(p.testGoal(initialState));
    } 
    */
    
}