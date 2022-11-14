import java.util.Random;
import java.util.Scanner;

class third {

  public static Scanner in = new Scanner(System.in);

  public static int rand(int min, int max) {
    Random random = new Random();

    return random.nextInt(max - min) + min;
  }

  public static int[] gen_arr() {
    int[] arr = new int[20];

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

  public static int par(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;
  }

  public static void quick_sort(int[] arr, int low, int high) {
    if (low < high) {
      int partition = par(arr, low, high);

      quick_sort(arr, low, partition - 1);
      quick_sort(arr, partition + 1, high);
    }
  }

  public static void main(String[] args) {
    int[] arr = gen_arr();

    System.out.print("Generated array: ");
    print_arr(arr);

    quick_sort(arr, 0, arr.length - 1);

    System.out.print("Sorted array: ");
    print_arr(arr);
  }
}
