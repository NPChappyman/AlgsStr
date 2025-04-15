package AVLtree;

import java.util.ArrayList;
import java.util.List;

public class AVLtree<T extends Comparable<T>> {
    private class Node {
        T key;
        int height;
        Node left;
        Node right;

        Node(T key) {
            this.key = key;
            this.height = 1;
        }
    }

    private Node root;

    // Получение высоты узла
    private int height(Node node) {
        return node == null ? 0 : node.height;
    }

    // Обновление высоты узла
    private void updateHeight(Node node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    // Получение баланс-фактора
    private int getBalance(Node node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    // Правый поворот
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        updateHeight(y);
        updateHeight(x);

        return x;
    }

    // Левый поворот
    private Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        updateHeight(x);
        updateHeight(y);

        return y;
    }

    // Вставка ключа
    public void insert(T key) {
        root = insert(root, key);
    }

    private Node insert(Node node, T key) {
        if (node == null) {
            return new Node(key);
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = insert(node.left, key);
        } else if (cmp > 0) {
            node.right = insert(node.right, key);
        } else {
            return node; // Дубликаты не допускаются
        }

        updateHeight(node);
        return balance(node, key);
    }

    // Удаление ключа
    public void delete(T key) {
        root = delete(root, key);
    }

    private Node delete(Node node, T key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            node.left = delete(node.left, key);
        } else if (cmp > 0) {
            node.right = delete(node.right, key);
        } else {
            // Узел с одним или без детей
            if (node.left == null || node.right == null) {
                Node temp = (node.left != null) ? node.left : node.right;
                if (temp == null) {

                    node = null;
                } else {
                    node = temp;
                }
            } else {
                // Узел с двумя детьми: получаем преемника (минимальный в правом поддереве)
                Node temp = minValueNode(node.right);
                node.key = temp.key;
                node.right = delete(node.right, temp.key);
            }
        }

        if (node == null) {
            return null;
        }

        updateHeight(node);
        return balance(node, node.key); // Используем текущий ключ узла для балансировки
    }

    // Поиск минимального узла
    private Node minValueNode(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Балансировка узла
    private Node balance(Node node, T key) {
        int balance = getBalance(node);

        // Лево-левый случай
        if (balance > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }
        // Право-правый случай
        if (balance < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }
        // Лево-правый случай
        if (balance > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Право-левый случай
        if (balance < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // Поиск ключа
    public boolean contains(T key) {
        return contains(root, key);
    }

    private boolean contains(Node node, T key) {
        if (node == null) {
            return false;
        }

        int cmp = key.compareTo(node.key);
        if (cmp < 0) {
            return contains(node.left, key);
        } else if (cmp > 0) {
            return contains(node.right, key);
        } else {
            return true;
        }
    }

    // Обход дерева в порядке "in-order" (левый-корень-правый)
    public List<T> inOrder() {
        List<T> result = new ArrayList<>();
        inOrder(root, result);
        return result;
    }

    private void inOrder(Node node, List<T> result) {
        if (node != null) {
            inOrder(node.left, result);
            result.add(node.key);
            inOrder(node.right, result);
        }
    }

    // Обход дерева в порядке "pre-order" (корень-левый-правый)
    public List<T> preOrder() {
        List<T> result = new ArrayList<>();
        preOrder(root, result);
        return result;
    }

    private void preOrder(Node node, List<T> result) {
        if (node != null) {
            result.add(node.key);
            preOrder(node.left, result);
            preOrder(node.right, result);
        }
    }

    // Обход дерева в порядке "post-order" (левый-правый-корень)
    public List<T> postOrder() {
        List<T> result = new ArrayList<>();
        postOrder(root, result);
        return result;
    }

    private void postOrder(Node node, List<T> result) {
        if (node != null) {
            postOrder(node.left, result);
            postOrder(node.right, result);
            result.add(node.key);
        }
    }

    // Получение высоты дерева
    public int height() {
        return height(root);
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return root == null;
    }
}