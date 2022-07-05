package codewars;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Example - following tree:

                 2
            8        9
          1  3     4   5

Should return following list: [2,8,9,1,3,4,5]
 */

class Node {

    public static void main(String[] args) {
        Node node = new Node(new Node(null, new Node(null, null, 4), 2), new Node(new Node(null, null, 5), new Node(null, null, 6), 3), 1);

        SortTreeByLevel.treeByLevels(node);
        SortTreeByLevel.treeByLevels(null);
    }

    public Node left;
    public Node right;
    public int value;

    public Node(Node l, Node r, int v) {
        left = l;
        right = r;
        value = v;
    }
}

public class SortTreeByLevel {
    public static List<Integer> treeByLevels(Node node)
    {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if(node == null){
            return result;
        }

        queue.add(node);
        result.add(node.value);
        while (!queue.isEmpty()){
            Node tempNode = queue.poll();

            if (tempNode.left != null) {
                queue.add(tempNode.left);
                result.add(tempNode.left.value);
            }

            if (tempNode.right != null) {
                queue.add(tempNode.right);
                result.add(tempNode.right.value);
            }
        }
        System.out.println(result);
        return result;
    }
}