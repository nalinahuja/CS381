import java.util.*;

public class MaxIndependentWeightedSet {
  public static int inc_weights[];
  public static int exc_weights[];

  /**
   * Wrapper Function For computeWeights Method
   * @return an int
   * @runtime O(n)
   */
  public static int computeMaximumWeightSet(Node root, int n) {
    inc_weights = new int[n];
    exc_weights = new int[n];
    
    computeWeights(root);
    return (Math.max(with[root], without[root]));
  }

  /**
   * Function Computes Maximum Weight Of An Independent Set Of Nodes
   * @return void 
   * @runtime O(n)
   */
  public static void computeWeights(Node root) {
    if (root.decendants.size() == 0) {
      inc_weights[root.v - 1] = root.w;
      exc_weights[root.v - 1] = 0;
    } else {
      int exc_sum = 0;
      int max_sum = 0;

      for (Node decendant : root.decendants) {
        computeWeights(decendant);
        exc_sum += exc_weights[decendant.v - 1];
        max_sum += Math.max(inc_weights[decendant.v - 1], exc_weights[decendant.v - 1]);
      }

      inc_weights[root.v - 1] = root.w + exc_sum;
      exc_weights[root.v - 1] = max_sum;
    }
  }
}

class Node {
  int v, w;
  LinkedList<Node> decendants;

  public Node(int vIn) {
    this.w = 0;
    this.v = vIn;
    this.decendants = new LinkedList<Node>();
  }

  public void insertDecendant(Node n) {
    this.decendants.add(n);
  }
}
