package array;//Returns the index of element which is greater than or equal
// to our value

class LowerBound {

  public static int lowerBound(int[] arr, int left, int right, int value) {
    while (left < right) {
      int mid = (left + right) / 2;
      if (arr[mid] >= value) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }
    return left;
  }


  public static void main(String[] args) {
    System.out.println(lowerBound(new int[]{3, 3, 4}, 0, 3, 3));
  }
}
