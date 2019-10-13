public class Problem {
    Character[] initialState;
    Character[] goalState;
    String[] actions;

    public Problem(Character[] initialState, Character[] goalState, 
                    String[] actions) {
            
        this.initialState = initialState;
        this.goalState = goalState;
        this.actions = actions;
    }

    public boolean testGoal(Character[] state) {
        boolean isGoal = (this.goalState == state) ? true : false;
        return isGoal;
    }

    /* Test the problem class
    public static void main(String[] args) { 
        Character[] initialState = {'1', '2', '3', '8', '0', '4', '7', '6', '5'};
        Character[] goalState = {'1', '2', '3', '4', '5', '6', '7', '8', '0'};
        String[] actions = {"up", "down", "left", "right"};

        Problem p = new Problem(initialState, goalState, actions);
        System.out.println(p.testGoal(initialState));
    } 
    */
    
}