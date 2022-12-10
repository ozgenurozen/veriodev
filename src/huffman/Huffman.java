/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package huffman;


//özge nur özen 02195076046



import java.util.PriorityQueue;
import java.util.Comparator;

class huffmann {
  int item;
  char c;
  huffmann sag;
  huffmann sol;
}

// For comparing the nodes
class ImplementComparator implements Comparator<huffmann> {
  public int compare(huffmann x, huffmann y) {
    return x.item - y.item;
  }
}

// IMplementing the huffman algorithm
public class Huffman {
  public static void koduyaz(huffmann root, String s) {
    if (root.sag == null && root.sol == null && Character.isLetter(root.c)) {

      System.out.println(root.c + "   |  " + s);

      return;
    }
    koduyaz(root.sag, s + "0");
    koduyaz(root.sol, s + "1");
  }

  public static void main(String[] args) {

    int n = 4;
    char[] chardizi = { 'A', 'B', 'C', 'D' };
    int[] chardeger = { 5, 1, 6, 3 };

    PriorityQueue<huffmann> q = new PriorityQueue<huffmann>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) {
      huffmann hn = new huffmann();

      hn.c = chardizi[i];
      hn.item = chardeger[i];

      hn.sag = null;
      hn.sol = null;

      q.add(hn);
    }

    huffmann root = null;

    while (q.size() > 1) {

      huffmann x = q.peek();
      q.poll();

      huffmann y = q.peek();
      q.poll();

      huffmann f = new huffmann();

      f.item = x.item + y.item;
      f.c = '-';
      f.sag = x;
      f.sol = y;
      root = f;

      q.add(f);
    }
    System.out.println(" Char | Huffman code ");
    System.out.println("--------------------");
    koduyaz(root, "");
  }
}
