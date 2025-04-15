package AVL;

import RedBlackTree.RedBlackTree;

import java.util.Stack;

class Node<T> {
    public T data;
    public Node<T> left;
    public Node<T> right;

    public Node(T data) {
        this.data = data;
    }
}

class AVL<T extends Comparable<T>> {
    public Node<T> root;

    public void displayTree() {
        Stack<Node<T>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            Stack<Node<T>> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(" ");
            while (!globalStack.isEmpty()) {
                Node<T> temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if (temp.left != null || temp.right != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(" ");
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println("......................................................");
    }

    public AVL() {
    }

    public void add(T data) {
        Node<T> newItem = new Node<>(data);
        if (root == null) {
            root = newItem;
        } else {
            root = recursiveInsert(root, newItem);
        }
    }

    private Node<T> recursiveInsert(Node<T> current, Node<T> n) {
        if (current == null) {
            return n;
        } else if (n.data.compareTo(current.data) < 0) {
            current.left = recursiveInsert(current.left, n);
            current = balanceTree(current);
        } else if (n.data.compareTo(current.data) > 0) {
            current.right = recursiveInsert(current.right, n);
            current = balanceTree(current);
        }
        return current;
    }

    private Node<T> balanceTree(Node<T> current) {
        int bFactor = balanceFactor(current);
        if (bFactor > 1) {
            if (balanceFactor(current.left) > 0) {
                current = rotateLL(current);
            } else {
                current = rotateLR(current);
            }
        } else if (bFactor < -1) {
            if (balanceFactor(current.right) > 0) {
                current = rotateRL(current);
            } else {
                current = rotateRR(current);
            }
        }
        return current;
    }

    public void delete(T target) {
        root = delete(root, target);
    }

    private Node<T> delete(Node<T> current, T target) {
        Node<T> parent;
        if (current == null) {
            return null;
        } else {
            // left subtree
            if (target.compareTo(current.data) < 0) {
                current.left = delete(current.left, target);
                if (balanceFactor(current) == -2) {
                    if (balanceFactor(current.right) <= 0) {
                        current = rotateRR(current);
                    } else {
                        current = rotateRL(current);
                    }
                }
            }
            // right subtree
            else if (target.compareTo(current.data) > 0) {
                current.right = delete(current.right, target);
                if (balanceFactor(current) == 2) {
                    if (balanceFactor(current.left) >= 0) {
                        current = rotateLL(current);
                    } else {
                        current = rotateLR(current);
                    }
                }
            }
            // if target is found
            else {
                if (current.right != null) {
                    // delete its inorder successor
                    parent = current.right;
                    while (parent.left != null) {
                        parent = parent.left;
                    }
                    current.data = parent.data;
                    current.right = delete(current.right, parent.data);
                    if (balanceFactor(current) == 2) { // rebalancing
                        if (balanceFactor(current.left) >= 0) {
                            current = rotateLL(current);
                        } else {
                            current = rotateLR(current);
                        }
                    }
                } else {
                    // if current.left != null
                    return current.left;
                }
            }
        }
        return current;
    }
    public void find(T key) {
        if (find(key, root) != null) {
            System.out.println(key + " was found!");
        } else {
            System.out.println("Nothing found!");
        }
    }

    private Node<T> find(T target, Node<T> current) {
        if (current == null) {
            return null;
        }
        if (target.compareTo(current.data) < 0) {
            return find(target, current.left);
        } else if (target.compareTo(current.data) > 0) {
            return find(target, current.right);
        } else {
            return current; // target found
        }
    }



    private void inOrderDisplayTree(Node<T> current) {
        if (current != null) {
            inOrderDisplayTree(current.left);
            System.out.print("(" + current.data + ") ");
            inOrderDisplayTree(current.right);
        }
    }

    private int max(int l, int r) {
        return Math.max(l, r);
    }

    private int getHeight(Node<T> current) {
        if (current == null) {
            return 0;
        }
        int l = getHeight(current.left);
        int r = getHeight(current.right);
        return max(l, r) + 1;
    }

    private int balanceFactor(Node<T> current) {
        return getHeight(current.left) - getHeight(current.right);
    }

    private Node<T> rotateRR(Node<T> parent) {
        Node<T> pivot = parent.right;
        parent.right = pivot.left;
        pivot.left = parent;
        return pivot;
    }

    private Node<T> rotateLL(Node<T> parent) {
        Node<T> pivot = parent.left;
        parent.left = pivot.right;
        pivot.right = parent;
        return pivot;
    }

    private Node<T> rotateLR(Node<T> parent) {
        parent.left = rotateRR(parent.left);
        return rotateLL(parent);
    }

    private Node<T> rotateRL(Node<T> parent) {
        parent.right = rotateLL(parent.right);
        return rotateRR(parent);
    }
    public  static  void main(String[] args)
    {
        AVL<Integer> w = new AVL<Integer>();
        w.add(131);
        w.add(131123);
        w.add(123);
        w.add(1321);
        w.add(137);w.add(138);w.add(139);w.add(140);w.add(141);w.add(142);
        w.displayTree();
        w.delete(140);w.delete(1321);w.delete(142);
        w.displayTree();

    }
}


