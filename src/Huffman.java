// Huffman Coding in Java

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

class HuffmanNode {
  int item;
  char c;
  HuffmanNode left;
  HuffmanNode right;
}

// For comparing the nodes
class ImplementComparator implements Comparator<HuffmanNode> {
  public int compare(HuffmanNode x, HuffmanNode y) {
    return x.item - y.item;
  }
}

// IMplementing the huffman algorithm
public class Huffman {
  public static void printCode(HuffmanNode root, String s) {
    if (root.left == null && root.right == null && Character.isLetter(root.c)) {

      System.out.println(root.c + "   |  " + s);

      return;
    }
    printCode(root.left, s + "0");
    printCode(root.right, s + "1");
  }

  public static Map<String, Object> preProcessMessage(String message) {
    // Keep an internal map for count
    Map<Character, Integer> counts = new HashMap<>();

    for (int i = 0; i < message.length(); i++) {
      final char current = message.charAt(i);
      Integer count = counts.get(current);
      if (count == null) {
        counts.put(current, 1);
      } else {
        counts.put(current, count + 1);
      }
    }

    // Now create a hashmap as a result
    Map<String, Object> result = new HashMap<>();

    // Put in the size
    result.put("n", counts.size());

    // Create the arrays of char and its corresponding frequency
    int[] charFreq = new int[counts.size()];
    char[] charArry = new char[counts.size()];
    int count = 0;
    
    for (Entry<Character, Integer> entry: counts.entrySet()) {
      charArry[count] = entry.getKey();
      charFreq[count] = entry.getValue();
      count++;
    }

    // Put in the char array of present characters
    result.put("charArray", charArry);
    result.put("charFreq", charFreq);

    return result;
  }

  public static void runHuffman() {

    // Create a scanner for stdin
    final Scanner stdInScan = new Scanner(System.in);

    // Prompt the user to enter a long text
    System.out.print("Type the message to encode (no space): ");

    // Get the message
    String message = stdInScan.nextLine();

    // Close scanner
    stdInScan.close();

    // Process the message
    Map<String, Object> processedResult = preProcessMessage(message);

    int n = (Integer) processedResult.get("n");
    char[] charArray = (char[]) processedResult.get("charArray");
    int[] charfreq = (int[]) processedResult.get("charFreq");

    PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());

    for (int i = 0; i < n; i++) {
      HuffmanNode hn = new HuffmanNode();

      hn.c = charArray[i];
      hn.item = charfreq[i];

      hn.left = null;
      hn.right = null;

      q.add(hn);
    }

    HuffmanNode root = null;

    while (q.size() > 1) {

      HuffmanNode x = q.peek();
      q.poll();

      HuffmanNode y = q.peek();
      q.poll();

      HuffmanNode f = new HuffmanNode();

      f.item = x.item + y.item;
      f.c = '-';
      f.left = x;
      f.right = y;
      root = f;

      q.add(f);
    }
    System.out.println(" Char | Huffman code ");
    System.out.println("--------------------");
    printCode(root, "");
  
  }

  public static void main(String[] args) {  
    try {
      runHuffman();
    } catch (Exception e) {
      System.out.println("Please check your input for spaces!");
    }
  }
}
