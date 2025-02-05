package haffman;

import java.io.*;
import java.util.*;
import java.util.Comparator;
class HaffmanTree implements Comparable<HaffmanTree>
{
    private Node root; // Единственное поле данных
    public Node getroot()
    {
        return root;
    }
    public void setroot(Node w)
    {
        root= w;
    }
    public HaffmanTree(Node w)
    {
        setroot(w);
    }
    public HaffmanTree()
    {
    }
    public static HaffmanTree sliv(HaffmanTree a1 , HaffmanTree a2)
    {
        HaffmanTree res = new HaffmanTree();
        Node resNode = new Node();
        resNode.iData = a1.root.iData+a2.root.iData;
        res.setroot(resNode);
        res.root.leftChild = a1.root;
        res.root.rightChild = a2.root;
        return  res;
    }
    @Override
    public int compareTo(HaffmanTree other) {
        return Integer.compare(this.root.iData, other.root.iData); // Сравнение по iData
    }
}