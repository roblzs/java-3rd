import java.util.Random;
import java.util.Scanner;

public class second {

  public static Scanner in = new Scanner(System.in);

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

  public static void select_sort(int[] arr) {
    int loop = 0;

    int smallest_index = 0, greatest_index = 0, smallest_el = 0, greatest_el =
      0;

    int[] indexed = new int[arr.length];

    boolean sorted = false;

    int indexor = 0;

    while (indexor < indexed.length) {
      for (int i = loop; i < arr.length; i++) {
        boolean contained = false;

        for (int j = 0; j < indexed.length; j++){
            if(contained){
                continue;
            }

            if(i == indexed[j]){
                contained = true;
            }
        }

        if(contained){
            continue;
        }

        if (arr[i] < arr[smallest_index]) {
          smallest_index = i;
          smallest_el = arr[i];
        } else if (arr[i] > greatest_index) {
          greatest_index = i;
          greatest_el = arr[i];
        }
      }

      arr[greatest_index] = smallest_el;
      arr[smallest_index] = greatest_el;

      indexed[indexor] = smallest_index;
      indexor++;
      indexed[indexor] = greatest_index;
      indexor++;
      
      System.out.println(indexor);
    }

    print_arr(arr);
  }

  public static void main(String[] args) {
    select_sort(gen_arr());

    in.close();
  }
}
