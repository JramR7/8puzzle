public class NaryNode{

    Character[] state;
    NaryNode parent;
    String action;
    int depth;
    double cost;
    double key;

    public NaryNode(Character[] state, NaryNode parent, String action, 
                    int depth, double cost, double key) {
        
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.depth = depth;
        this.cost = cost;
        this.key = key;
    }

    public static void main(String[] args) {
        Character[] state = {'1', '2', '3', '8', '0', '4', '7', '6', '5'};
        NaryNode parent = null;
        String action = "up";
        int depth = 0;
        double cost = 0;
        double key = 0;

        /* Test the NaryNode class
        NaryNode node = new NaryNode(state, parent, action, depth, cost, key);
        System.out.println("state:" + node.state);
        System.out.println("parent:" + node.parent);
        System.out.println("action:" + node.action);
        System.out.println("depth:" + node.depth);
        System.out.println("cost:" + node.cost);
        System.out.println("key:" + node.key);
    }*/
}