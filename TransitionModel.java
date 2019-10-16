import java.util.Arrays;

public class TransitionModel {
    public String runAction(String actualState, String actionType) {
        int blankPos = actualState.indexOf('0');

        switch (actionType) {
            case "up":
                if (blankPos > 2) {
                    return action(actualState, blankPos, -3);
                }
                return null;

            case "down":
                if (blankPos < 5) {
                    return action(actualState, blankPos, 3);
                }
                return null;

            case "left":
                if ((blankPos % 3) != 0) {
                    return action(actualState, blankPos, -1);
                }
                return null;

            case "right":
                if (((blankPos + 1) % 3) != 0) {
                    return action(actualState, blankPos, 1);
                }
                return null;

            default:
                return null;
        }
    }

    private String action(String actualState, int blankPos, int actionMove) {
        StringBuilder actionState = new StringBuilder(actualState);
        
        actionState.setCharAt(blankPos + actionMove, actualState.charAt(blankPos));
        actionState.setCharAt(blankPos, actualState.charAt(blankPos + actionMove));

        return actionState.toString();
    }

    /*Test the transition model class
    public static void main(String[] args) { 
        TransitionModel t = new TransitionModel();
        
        Character[] state = {'1', '2', '3', '8', '0', '4', '7', '6', '5'};

        t.runAction(state, "up");
        t.runAction(state, "down");
        t.runAction(state, "left");
        t.runAction(state, "right");
    } */
}
