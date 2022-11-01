import java.util.Random;
import java.util.Scanner;

class First {

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

  public static int[] gen_arr() {
    int[] arr = new int[5];

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
    int[] arr = gen_arr();

    System.out.println("Generated array: ");
    print_arr(arr);

    System.out.println("Choose search method: ");
    System.out.println("1 [linear search]");
    System.out.println("2 [linear search with brier]");

    int choice = -1;

    try {
      System.out.print("Choice: ");
      choice = in.nextInt();
    } catch (Exception e) {
      System.out.print("Something went wrong");
      in.close();
      return;
    }

    int el = -1;

    try {
      System.out.print("Enter element You want to find: ");
      el = in.nextInt();
    } catch (Exception e) {
      System.out.print("Something went wrong");
      in.close();
      return;
    }

    in.close();

    int l_s = -1;

    if (choice == 1) {
      l_s = linear_search(arr, el);
    } else {
      l_s = linear_search_barier(arr, el);
    }

    if (l_s < 0) {
      System.out.println("Couldn't find the element You were looking for");
      return;
    }

    System.out.println("Element found at index " + l_s);
  }
}
