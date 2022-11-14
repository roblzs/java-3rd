import java.util.Random;
import java.util.Scanner;

public class first2 {

  public static void printArray(int[] arr) {
    String prnt = "";

    for (int i = 0; i < arr.length; i++) {
      prnt += arr[i];
      prnt += ", ";
    }

    System.out.println(prnt);
  }

  public static int linearSearch(int[] arr, int el) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == el) {
        return i;
      }
    }

    return -1;
  }

  public static int linearBarier(int[] arr, int el) {
    int lastI = arr.length - 1;
    int last = arr[lastI];
    arr[lastI] = el;

    if (last == el) {
      return lastI;
    }

    for (int i = 0; i <= lastI; i++) {
      if (arr[i] == el) {
        return i;
      }

      if (i == lastI) {
        return -1;
      }
    }

    return -1;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Random random = new Random();

    int[] a = new int[5];

    for (int i = 0; i < a.length; i++) {
      a[i] = random.nextInt(100 - 0);
    }

    System.out.println("Created array: ");
    printArray(a);

    System.out.println("Choose search method: ");
    System.out.println("1 - linear search");
    System.out.println("2 - linear search with brier");

    int choice = -1;

    System.out.print("Choice: ");
    choice = in.nextInt();

    int el = -1;

    System.out.print("Enter element You want to find: ");
    el = in.nextInt();

    in.close();

    int fIndex = -1;

    if (choice == 1) {
      fIndex = linearSearch(a, el);
    } else {
      fIndex = linearBarier(a, el);
    }

    if (fIndex < 0) {
      System.out.println("Element not found");
      return;
    }

    System.out.println("Element found at index " + fIndex);
  }
}
