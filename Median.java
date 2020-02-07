//Developed by Nalin Ahuja, nalinahuja22

public class Median {
  public static final int NOT_SET = -1;

  /**
   * Determines the median element between two sorted arrays.
   * @return the median
   * @runtime O(log(n))
   */
  public static int median(int arr1[], int arr2[]) {
    int i = (arr1.length / 2) - 1;
    int j = (arr2.length - 1) - i;
    int med = NOT_SET;

    int str = 0;
    int end = arr1.length - 1;

    if (str == end) {
      return Math.min(arr1[0], arr2[0]);
    }

    while (str <= end) {
      if (i > 0 && j > 0 && arr1[i] > arr2[j - 1] && arr2[j] > arr1[i - 1]) {
        med = Math.min(arr1[i], arr2[j]);
        break;
      } else if (i == 0 && j > 0 && arr1[i] > arr2[j - 1]) {
        med = Math.min(arr1[i], arr2[j]);
        break;
      } else if (i > 0 && j == 0 && arr2[j] > arr1[i - 1]) {
        med = Math.min(arr1[i], arr2[j]);
        break;
      }

      if (arr1[i] < arr2[j]) {
        str = ++i;
      } else if (arr2[j] < arr1[i]) {
        end = --i;
      }

      i = (str + end) / 2;
      j = (arr2.length - 1) - i;
    }

    return med;
  }
}
