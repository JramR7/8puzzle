import java.util.Arrays;

public class TransitionModel {
    public Character[] runAction(Character[] actualState, int blankPos, String actionType) {
        switch (actionType) {
            case "up":
                if (blankPos > 2) {
                    return action(actualState, blankPos, -3);
                }
                return actualState;

            case "down":
                if (blankPos < 5) {
                    return action(actualState, blankPos, 3);
                }
                return actualState;

            case "left":
                if ((blankPos % 3) != 0) {
                    return action(actualState, blankPos, -1);
                }
                return actualState;

            case "right":
                if (((blankPos + 1) % 3) != 0) {
                    return action(actualState, blankPos, 1);
                }
                return actualState;

            default:
                return actualState;
        }
    }

    private Character[] action(Character[] actualState, int blankPos, int actionMove) {
        Character[] actionState = actualState.clone();

        actionState[blankPos + actionMove] = actualState[blankPos];
        actionState[blankPos] = actualState[blankPos + actionMove];
        
        printState(actionState);
        return actionState;
    }

    private void printState(Character[] state) {
        for (int i = 0; i < state.length; i++) {
            System.out.print(state[i] + " ");

            if (((i+1)%3) == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    /* Test the transition model class
    public static void main(String[] args) { 
        TransitionModel t = new TransitionModel();
        
        Character[] state = {'1', '2', '3', '8', '0', '4', '7', '6', '5'};

        t.runAction(state, 4, "up");
        t.runAction(state, 4, "down");
        t.runAction(state, 4, "left");
        t.runAction(state, 4, "right");
    } */
}
