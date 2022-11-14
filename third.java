import java.lang.Math;

class Third {

  public static int partition(int[] a, int low, int high) {
    int pivot = a[high];
    int i = (low - 1);
    for (int j = low; j < high; j++) {
      if (a[j] <= pivot) {
        i++;
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
      }
    }
    int temp = a[i + 1];
    a[i + 1] = a[high];
    a[high] = temp;
    return i + 1;
  }

  public static void quicksort(int[] a, int low, int high) {
    if (low < high) {
      int p = partition(a, low, high);
      quicksort(a, low, p - 1);
      quicksort(a, p + 1, high);
    }
  }

  public static void main(String[] args) {
    int[] a = new int[100];
    for (int i = 0; i < a.length; i++) {
      double tmp = Math.random() * 100 + 1;
      a[i] = (int) tmp;
    }
    System.out.print("Unsorted array:\n");
    printArray(a);
    quicksort(a, 0, a.length - 1);
    System.out.print("Sorted array:\n");
    printArray(a);
  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) System.out.print(arr[i] + " ");
    System.out.println();
  }
}
