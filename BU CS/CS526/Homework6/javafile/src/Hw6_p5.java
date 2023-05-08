/**
 * Name: Jian Song
 * BU Email: jaysong@bu.edu
 */
import java.io.*;
import java.util.*;

public class Hw6_p5 {
    /**
     * Use a Node class to represent each person in the graph
     */
    static class Node {
        String name;
        ArrayList<String> follows;

        /**
         * Each node has a name and a list of people they follow
         */
        public Node(String name) {
            this.name = name;
            follows = new ArrayList<String>();
        }

        /**
         * add followed people to the list
         */
        public void addFollow(String name) {
            follows.add(name);
        }
    }

    /**
     * main method uses Scanner util to read the txt file, then calls allFollows method
     * to do unit tests.
     */
    public static void main(String[] args) {
        // Read input file
        String fileName = "follows_input.txt";
        // The adjacency list is built by reading the input file and creating a Node object
        // for each person, then add them to the list.
        ArrayList<Node> adjList = new ArrayList<Node>();
        try {
            Scanner reader = new Scanner(new File(fileName));
            while (reader.hasNextLine()) {
                String[] names = reader.nextLine().split(", ");
//              name of the person is the first string at each line
                Node node = new Node(names[0]);
//              the rest are people that person follows
                for (int i = 1; i < names.length; i++) {
                    node.addFollow(names[i]);
                }
                adjList.add(node);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        // Test allFollows method
        allFollows(adjList, "D");
        allFollows(adjList, "G");
        allFollows(adjList, "A");
    }

    /**
     * the allFollows method uses DFS to find all people that a give person follows indirectly
     * @param adjList: the adjacency list read from the input file
     * @param name: the name of the person to find follows for
     *            Output: void => print out the direct and indirect follows in specific formats
     */
    public static void allFollows(ArrayList<Node> adjList, String name) {
        HashSet<String> visited = new HashSet<String>();
        ArrayList<String> direct = new ArrayList<String>();
        ArrayList<String> indirect = new ArrayList<String>();
        Node node = null;

        // Find node with given name in adjacency list
        for (Node n : adjList) {
            if (n.name.equals(name)) {
                node = n;
                break;
            }
        }
//      direct follows is just the follows at the node
        direct = node.follows;
        // DFS to find all indirect follows
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        visited.add(node.name);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            for (String follow : curr.follows) {
                if (!visited.contains(follow)) {
//                  mark visited
                    visited.add(follow);
//                  for indirect follows, make sure they are not contained in direct follows already
                    if (!direct.contains(follow)) {
                    indirect.add(follow);
                    }
//                     iterates over the adjList of nodes, searching for a node with a name equal to follow.
//                     If it finds a match, it adds that node to the stack
//                     so that its own followers can be processed later in the DFS
                    for (Node n : adjList) {
                        if (n.name.equals(follow)) {
                            stack.push(n);
                            break;
                        }
                    }
                }
            }
        }

        // Print output (replace [] with {} to match the expected output in the homework instruction
        System.out.println(name + " directly follows " + "{" + String.join(",", direct) + "}");
        System.out.println(name + " indirectly follows " + "{" + String.join(",", indirect) + "}");
    }
}
