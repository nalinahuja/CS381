//Developed by Nalin Ahuja, nalinahuja22

public class MinMax {
  //Wrapper Function
  public static int[] getMinMax(int arr[]) {
    return divide(arr, 0, arr.length - 1);
  }

  //Runtime Of O(n)
  public static int[] divide(int arr[], int l, int r) {
    if ((r - l) <= 1) {
      int lmin = arr[l];
      int lmax = arr[r];

      if (lmin > lmax) {
        lmin = lmin + lmax;
        lmax = lmin - lmax;
        lmin = lmin - lmax;
      }

      return (new int[]{lmin, lmax});
    } else {
      int lmm[] = divide(arr, (l + r) / 2 + 1, r);
      int rmm[] = divide(arr, l, (l + r) / 2);

      return (new int[]{Math.min(lmm[0], rmm[0]), Math.max(lmm[1], rmm[1])});
    }
  }
}
