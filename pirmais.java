import java.util.Random;
import java.util.Scanner;

class Pirmais {

  public static Scanner in = new Scanner(System.in);

  public static int rand(int min, int max) {
    Random random = new Random();

    return random.nextInt(max - min) + min;
  }

  public static void print_arr(int[] arr) {
    String prnt = "";

    for (int i = 0; i < arr.length; i++) {
      prnt += arr[i];
      prnt += ", ";
    }

    System.out.println(prnt);
  }

  public static int[] gen_arr(int len) {
    int[] arr = new int[len];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = rand(0, 100);
    }

    return arr;
  }

  public static int linear_search(int[] arr, int el) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == el) {
        return i;
      }
    }

    return -1;
  }

  public static int linear_search_barier(int[] arr, int el) {
    int last_index = arr.length - 1;
    int last = arr[last_index];
    arr[last_index] = el;

    if (last == el) {
      return last_index;
    }

    int i = 0;

    while (arr[i] != el & i != last_index) {
      i++;
    }

    if (i == last_index) {
      return -1;
    }

    return i;
  }

  public static void main(String[] args) {
    int[] values = new int[] { 100, 200, 10000 };
    long[][] times = new long[values.length][2];

    for (int i = 0; i < values.length; i++) {
      int val = values[i];

      int[] arr = gen_arr(val);

      System.out.println("Generated array: ");
      print_arr(arr);

      int el = -1;

      try {
        System.out.print("Enter element You want to find: ");
        el = in.nextInt();
      } catch (Exception e) {
        System.out.print("Something went wrong");
        in.close();
        return;
      }

      int l_s = -1;

      long startTime = System.nanoTime();
      l_s = linear_search(arr, el);
      long endTime = System.nanoTime() - startTime;

      times[i][0] = endTime;

      startTime = System.nanoTime();
      l_s = linear_search_barier(arr, el);
      endTime = System.nanoTime() - startTime;

      times[i][1] = endTime;

      if (l_s < 0) {
        System.out.println("Couldn't find the element You were looking for");
      } else {
        System.out.println("Element found at index " + l_s);
      }
    }

    System.out.println("Execution times:");

    for (long[] vals : times) {
      String res = vals[0] < vals[1]
        ? " < "
        : (vals[0] == vals[1]) ? " = " : " > ";

      System.out.println(vals[0] + res + vals[1]);
    }
  }
}
