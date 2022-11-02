import java.util.Random;

public class third {

  public static int rand(int min, int max) {
    Random random = new Random();

    return random.nextInt(max - min) + min;
  }

  public static int[] gen_arr() {
    int[] arr = new int[5];

    for (int i = 0; i < arr.length; i++) {
      arr[i] = rand(0, 100);
    }

    return arr;
  }

  public static void print_arr(int[] arr) {
    String prnt = "";

    for (int i = 0; i < arr.length; i++) {
      prnt += arr[i];
      prnt += ", ";
    }

    System.out.println(prnt);
  }

  public static int partiotion(int[] arr, int low, int high) {
    int i = low - 1;

    for (int j = low; j <= high; j++) {}

    return 0;
  }

  public static void quick_sort(int[] arr, int x) {
    while (x < arr.length) {
      int xel = arr[x];

      for (int i = 0; i < arr.length; i++) {
        int el = arr[i];

        if (el < xel) {
          arr[x - 1] = el;
        } else if (el > xel) {
          arr[x + 1] = el;
        }
      }

      x++;
    }

    System.out.println("Sorted array: ");
    print_arr(arr);
  }

  public static void main(String[] args) {
    int[] arr = gen_arr();

    System.out.println("Generated array: ");
    print_arr(arr);

    quick_sort(arr, 0);
  }
}
