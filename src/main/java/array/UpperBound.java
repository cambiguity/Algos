package array;// Returns the index of the array which is strictly greater
// than given value

public class UpperBound {

  private static int upperBound(int[] a, int low, int high, int value) {
    while (low < high) {
      int mid = (low + high) / 2;
      if (a[mid] <= value) {
        low = mid + 1;
      } else {
        high = mid;
      }
    }
    return low;
  }

  public static void main(String[] args) {
    System.out.println(upperBound(new int[]{1, 2}, 0, 2, 0));
  }


}
