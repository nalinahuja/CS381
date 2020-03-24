//Developed by Nalin Ahuja, nalinahuja22

import java.util.*;

public class MaximumIndependentSet {

 /**
   * Determines the Largest Non-Adjacent Subset Of Nodes Of A Rooted U-nary tree
   * @return a void
   * @runtime O(n)
   */
public static boolean determineNAS(Node root, List<Node> nas) {
    if (root.decendants.empty()) {
      nas.add(root);
      return false;
    } else {
      boolean currSelect = true;

      for (Node decendant : root.decendants) {
        currSelect &= determineNAS(decendant);
      }

      if (currSelect) {
        nas.add(root);
      }

      return (!currSelect);
    }
  }
}

class Node {
  int v;
  LinkedList<Node> decendants;

  public Node(int vIn) {
    this.v = vIn;
    this.decendants = new LinkedList<Node>();
  }
}
