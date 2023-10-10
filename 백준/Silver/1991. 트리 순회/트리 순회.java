import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final String EMPTY = ".";
    static Map<Integer, Set<Integer>> g_board = new HashMap<>();
    static int[] parent;
    static int g_root = 1;
    static Map<String, List<String>> g_map = null;
    public static void main(String[] args) throws IOException {
        // File file = new File("test.txt");
        // FileReader fileReader = new FileReader(file);
        // BufferedReader input = new BufferedReader(new BufferedReader(fileReader));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int cnt = Integer.parseInt(input.readLine());

        g_map = new HashMap<>();

        for (int i = 0; i < cnt; i++) {
            String[] str = input.readLine().split(" ");
            List<String> list = new ArrayList<>();
        
            list.add(str[1].equals(EMPTY) ? null : str[1]);
            list.add(str[2].equals(EMPTY) ? null : str[2]);

            g_map.put(str[0], list);
        }

        Node root = new Node("A", null, null);
        toNodes(g_map.get("A"), root);

        preSort(root);
        System.out.println();
        midSort(root);
        System.out.println();
        postSort(root);
    }

    public static void preSort(Node node) {
        if (node == null) return;

        System.out.print(node.value);
        preSort(node.getLeft());
        preSort(node.getRight());
    }

    public static void midSort(Node node) {
        if (node == null) return;

        midSort(node.getLeft());
        System.out.print(node.value);
        midSort(node.getRight());
    }


    public static void postSort(Node node) {
        if (node == null) return;

        postSort(node.getLeft());
        postSort(node.getRight());
        System.out.print(node.value);
    }

    public static void toNodes(List<String> list, Node parentNode) {
        String left = list.get(0);
        if (left != null) {
            Node leftNode = new Node(left, null, null);
            parentNode.setLeft(leftNode);
            toNodes(g_map.get(left), leftNode);
        }

        String right = list.get(1);
        if (right != null) {
            Node rightNode = new Node(right, null, null);
            parentNode.setRight(rightNode);
            toNodes(g_map.get(right), rightNode);
        }
    }

    static class Node {
        Node left;
        Node right;
        String value;

        public Node(String value, Node left, Node right) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public void setLeft(Node node) {
            this.left = node;
        }
        public Node getLeft() {
            return this.left;
        }
        

        public void setRight(Node node) {
            this.right = node;
        }
        public Node getRight() {
            return this.right;
        }
    }
}
