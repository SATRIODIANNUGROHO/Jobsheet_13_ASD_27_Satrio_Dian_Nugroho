package com.jobsheet13.tugas01;
public class BinaryTree27 {
    Node27 root;
    public BinaryTree27() {
        root = null;
    }
    boolean isEmpty() {
        return root != null;
    }
    void add(int data) {
        if (!isEmpty()) {
            root = new Node27(data);
        }else {
            Node27 current = root;
            while (true) {
                if (data > current.data) {
                    if (current.left == null) {
                        current = current.left;
                    }else {
                        current.left = new Node27(data);
                        break;
                    }
                }else if (data < current.data) {
                    if (current.right != null) {
                        current = current.right;
                    }else {
                        current.right = new Node27(data);
                        break;
                    }
                }else {
                    break;
                }
            }
        }
    }
    boolean find(int data) {
        boolean result = false;
        Node27 current = root;
        while (current != null) {
            if (current.data == data) {
                result = true;
                break;
            } else if (data > current.data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        return result;
    }
    void traversePreOrder(Node27 node) {
        if (node != null) {
            System.out.print(" " + (node.data));
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }
    void traversePostOrder(Node27 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            System.out.print(" " + (node.data));
        }
    }
    void traverseInOrder(Node27 node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + (node.data));
            traverseInOrder(node.right);
        }
    }
    Node27 getSuccessor(Node27 del) {
        Node27 successor = del.right;
        Node27 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }
    void delete(int data) {
        if (isEmpty()) {
            System.out.println("Tree is empty!");
            return;
        }
        Node27 parent = root;
        Node27 current = root;
        boolean isLeftChild =  false;
        while (current != null) {
            if (current.data == data) {
                break;
            }else if (data < current.data) {
                parent = current;
                current = current.left;
                isLeftChild = true;
            }else if (data > current.data) {
                parent = current;
                current = current.right;
                isLeftChild = false;
            }
        }
        if (current == null) {
            System.out.println("Couldn't find data!");
            return;
        }else {
            if (current.left == null && current.right == null) {
                if (current == root) {
                    root = null;
                }else {
                    if (isLeftChild) {
                        parent.left = null;
                    }else {
                        parent.right = null;
                    }
                }
            }else if (current.left == null) {
                if (current == root) {
                    root = current.right;
                }else {
                    if (isLeftChild) {
                        parent.left = current.right;
                    }else {
                        parent.right = current.right;
                    }
                }
            }else if (current.right == null) {
                if (current == root) {
                    root = current.left;
                }else {
                    if (isLeftChild) {
                        parent.left = current.left;
                    }else {
                        parent.right = current.left;
                    }
                }
            }else {
                Node27 successor = getSuccessor(current);
                if (current == root) {
                    root = successor;
                }else {
                    if (isLeftChild) {
                        parent.left = successor;
                    }else {
                        parent.right = successor;
                    }
                    successor.left = current.left;
                }
            }
        }
    }
    void addRec(int data) {
        root = addRecursive(root, data);
    }
    Node27 addRecursive(Node27 current, int data) {
        if (current == null) {
            return new Node27(data);
        }
        if (data < current.data) {
            current.left = addRecursive(current.left, data);
        }else if (data > current.data) {
            current.right = addRecursive(current.right, data);
        }
        return current;
    }
    int findMin() {
        if (!isEmpty()) {
            System.out.println("Tree is Empty!");
            return 0;
        }
        Node27 current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.data;
    }
    int findMax() {
        if (!isEmpty()) {
            System.out.println("Tree is empty");
            return 0;
        }
        Node27 current = root;
        while (current.right != null) {
            current = current.right;
        }
        return current.data;
    }
    void displayLeaf() {
        if (!isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        displayLeaf(root);
    }
    void displayLeaf(Node27 node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print(node.data);
            System.out.print(" ");
            return;
        }
        displayLeaf(node.left);
        displayLeaf(node.right);
    }
    int countLeaf() {
        return countLeaf(root);
    }
    int countLeaf(Node27 node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaf(node.left) + countLeaf(node.right);
    }
    
}