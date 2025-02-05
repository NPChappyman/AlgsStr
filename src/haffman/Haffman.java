package haffman;



import java.io.*;
import java.util.*;
public class Haffman {
    public String[] table = new String[256];
    public String enCode(String s)
    {
        HaffmanTree w  = buildhaffmanTree(s);
        obhod(w.getroot(),"");
        String res= "";
        for (int i=0;i<s.length();i++)
        {
            res+=table[(int) s.charAt(i)];
        }
        return res;
    }
    public String decode(String s)
    {
        String res ="";
        String decode="";
        for (int i = 0 ;i<s.length();i++)
        {
            res+=s.charAt(i);
            for (int j=0; j<table.length;j++)
            {
                if (res.equals(table[j]) )
                {
                    decode+=(char) j;
                    res="";
                    break;
                }
            }
        }
        return decode;
    }
    public void obhod(Node current, String res)
    {
        if (current!=null)
        {
            if (current.leftChild!=null){
                obhod(current.leftChild,res+"0");}
            if (current.rightChild!=null){
                obhod(current.rightChild,res+"1");}
            if (current.key!='\u0000') table[((int) current.key)]=res;
        }
    }
    public HaffmanTree buildhaffmanTree(String s)
    {
        HashMap<Character,Integer> hash = new HashMap<>();
        PriorityQueue<HaffmanTree> pQ = new PriorityQueue<>();
        for (int i = 0 ; i<s.length();i++)
        {
            if (!hash.containsKey(s.charAt(i)))
            {
                int amount = 1;
                for (int j = i+1;j<s.length()-1;j++)
                {
                    if (s.charAt(j)==s.charAt(i)) amount++;
                }
                hash.put(s.charAt(i),amount);
                Node list = new Node(s.charAt(i), amount);
                HaffmanTree listopad = new HaffmanTree(list);
                pQ.add(listopad);
            }
        }
        while (pQ.size()>1)
        {
            HaffmanTree res = HaffmanTree.sliv(pQ.remove(),pQ.remove());
            pQ.add(res);
        }
        return pQ.remove();
    }
}