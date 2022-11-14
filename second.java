import java.util.Random;
import java.util.Scanner;

public class second {

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

  public static void select_sort(int[] arr) {
    int indexor = 0;

    while(indexor < arr.length){
        int smallest_el = arr[indexor], smallest_index = indexor;
        int idx_el = arr[indexor];

        for (int i = indexor; i < arr.length; i++){
            int el = arr[i];

            if(el < smallest_el){
                smallest_el = el;
                smallest_index = i;
            }
        }

        arr[indexor] = smallest_el;
        arr[smallest_index] = idx_el;

        indexor ++;
    }

    System.out.print("Sorted array: ");
    print_arr(arr);
  }

  public static void main(String[] args) {
    int[] arr = gen_arr();

    System.out.print("Generated array: ");
    print_arr(arr);

    select_sort(arr);

    in.close();
  }
}
