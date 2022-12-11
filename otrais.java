import java.util.Random;
import java.util.Scanner;

public class otrais {

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

  public static void select_sort(int[] arr) {
    int indexor = 0;

    while (indexor < arr.length) {
      int smallest_el = arr[indexor], smallest_index = indexor;
      int idx_el = arr[indexor];

      for (int i = indexor; i < arr.length; i++) {
        int el = arr[i];

        if (el < smallest_el) {
          smallest_el = el;
          smallest_index = i;
        }
      }

      arr[indexor] = smallest_el;
      arr[smallest_index] = idx_el;

      indexor++;
    }

    System.out.print("Sorted array: ");
    print_arr(arr);
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
    int[] initArr = arr;

    System.out.print("Generated array: ");
    print_arr(arr);

    long startTime = System.nanoTime();
    quick_sort(initArr, 0, arr.length - 1);
    long endTime = System.nanoTime() - startTime;

    long startTime1 = System.nanoTime();
    select_sort(arr);
    long endTime1 = System.nanoTime() - startTime1;

    System.out.print("Sorted array: ");
    print_arr(arr);

    System.out.println("Execution times:");
    System.out.println("QS      SS");

    System.out.println(endTime + (endTime > endTime1 ? " > " : " < ") + endTime1);
  }
}
