package org.example.blind75.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Time complexity is O(nLog(n)), n is the unique nodes and logn is the time required to minheapify
Space complexity is O(n)
 */
public class HuffmanCoding {
    public static void printNode(Huffman root, String s)
    {
        if (root.left == null && root.right == null
                && Character.isLetter(root.c)) {
            System.out.println(root.c + ":" + s);
            return;
        }
        printNode(root.left, s + "0");
        printNode(root.right, s + "1");
    }
    public static void main(String[] args) {
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };
        PriorityQueue<Huffman> pq = new PriorityQueue<Huffman>(n, new MyComparator());
        for(int i =0;i<n;i++){
            Huffman huff = new Huffman();
            huff.data = charfreq[i];
            huff.c = charArray[i];
            huff.left = null;
            huff.right = null;
            pq.add(huff);
        }
        Huffman root = null;
        while(pq.size() > 1){
            Huffman x = pq.peek();
            pq.poll();
            Huffman y = pq.peek();
            pq.poll();
            Huffman f = new Huffman();
            f.data = x.data+y.data;
            f.c = '-';
            f.left = x;
            f.right = y;
            root = f;

            pq.add(f);
        }
        printNode(root, "");
    }

}
class Huffman{
    int data;
    char c;
    Huffman left;
    Huffman right;
}
class MyComparator implements Comparator<Huffman> {
    public int compare(Huffman a, Huffman b){
        return a.data - b.data;
    }
}

