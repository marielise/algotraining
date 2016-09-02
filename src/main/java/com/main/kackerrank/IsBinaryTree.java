package com.main.kackerrank;

import java.util.Scanner;
import java.util.Vector;

/**
 * Created by mlhamel on 9/1/16.
 */
public class IsBinaryTree {


    // List of node data values:
    Vector<Integer> values;
    // Total number of nodes in the tree:
    private int count;

    IsBinaryTree() {
        this.values = new Vector<Integer>();
        this.count = 0;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node() {
            this.data = -1;
            this.left = null;
            this.right = null;
        }
    }


    boolean checkBST(Node root) {
        return checkBST(root, null, null);
    }

    boolean checkBST(Node node, Integer min, Integer max){
        if(node == null)
            return true;

        if(min != null && node.data >= min) return false;  //left tree
        if(max != null && node.data <= max) return false;  //right tree

        return checkBST(node.left, node.data, max) && checkBST(node.right, min, node.data);
    }

    void inOrder (Node root, int levels) {

        if(root != null) {
            // If there are still unfilled levels, fill left subtree:
            if (levels > 0) {
                // Create a new left child node:
                root.left = new Node();
                inOrder(root.left, levels - 1);
            }

            // Set node data:
            root.data = values.elementAt(count);
            count++;

            // If there are still unfilled levels, fill right subtree:
            if (levels > 0) {
                // Create a new right child node:
                root.right = new Node();
                inOrder(root.right, levels - 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        int height = scanner.nextInt();
        int nbNode = scanner.nextInt();

        // Read data values for tree's nodes:
        IsBinaryTree tree = new IsBinaryTree();
        while(--nbNode>-1) {
            tree.values.add(scanner.nextInt());
        }
        scanner.close();

        // Fill tree:
        Node root = new Node();
        tree.inOrder(root, height);

        // Print result:
        System.out.println( (tree.checkBST(root) == true) ? "Yes" : "No" );

    }

    /*
    2 7
1 2 4 3 5 6 7
     */

}
