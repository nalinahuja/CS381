//Developed by Nalin Ahuja, nalinahuja22

public class MaxSquare {
  /**
   * Function determines the largest block of 1s arr
   * @return the max square side length
   * @runtime O(n^2)
   */
   
  public static int findMaxDim(int arr[][]) {
    int dp[][] = new int[arr.length][arr.length];

    for (int i = 0; i < arr.length; ++i) {
      dp[0][i] = arr[0][i];
      dp[i][0] = arr[i][0];
    }

    int max = Integer.MIN_VALUE;

    for (int i = 1; i < arr.length; ++i) {
      for (int j = 1; j < arr[i].length; ++j) {
        if (arr[i][j] == 0) {
          dp[i][j] = 0;
        } else {
          dp[i][j] = Math.min(arr[i][j-1], Math.min(arr[i-1][j], arr[i-1][j-1])) + 1;

          if (max < dp[i][j]) {
            max = dp[i][j];
          }
        }
      }
    }

    return max;
  }
}
