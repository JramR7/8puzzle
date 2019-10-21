import java.util.*;
public class NaryNode{

    String state;
    NaryNode parent;
    String action;
    int depth;
    double cost;
    double key;
    double gn;
    double hn;

    public NaryNode(String state, NaryNode parent, String action, 
                    int depth, double cost, double key, double gn, double hn) {
        
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.depth = depth;
        this.cost = cost;
        this.key = key;
        this.gn = gn;
        this.hn = hn;
    }

    public ArrayList<String[]> getSolution(NaryNode finalNode) {
        ArrayList<String[]> solution = new ArrayList<String[]>();
    
        while(finalNode.parent != null) {
            String[] nodeAction = {finalNode.action, finalNode.state};
            solution.add(nodeAction);
            finalNode = finalNode.parent;
        }
        return solution;
    }

    /* Test the NaryNode class
    public static void main(String[] args) {
        String state = {"123804765"};
        NaryNode parent = null;
        String action = "up";
        int depth = 0;
        double cost = 0;
        double key = 0;

        NaryNode node = new NaryNode(state, parent, action, depth, cost, key);
        System.out.println("state:" + node.state);
        System.out.println("parent:" + node.parent);
        System.out.println("action:" + node.action);
        System.out.println("depth:" + node.depth);
        System.out.println("cost:" + node.cost);
        System.out.println("key:" + node.key);
    }*/
}