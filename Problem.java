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
}