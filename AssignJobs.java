//Developed by Nalin Ahuja, nalinahuja22

public class AssignJobs {
  public static int NOT_SET = -1;

  /**
   * Function Assigns Jobs To Machines In Greedy Fashion
   * @return void
   * @runtime O(mn)
   */
  public static void assignJobs(int machines[], Job jobs[]) {
    int remJobs = jobs.length;

    while (remJobs > 0) {
      for (int i = 0; i < machines.length; ++i) {
        int ltr = Integer.MAX_VALUE;
        int selJob = NOT_SET;

        for (int j = 0; j < jobs.length; ++j) {
          if (jobs[j] != null) {
            if ((i + 1 >= jobs[j].l) && (i + 1 <= jobs[j].r)) {
              if (jobs[j].r < ltr) {
                ltr = jobs[j].r;
                selJob = j;
              }
            }
          }
        }

        if (selJob != NOT_SET) {
          System.out.printf("Machine %d → %d\n", i + 1, selJob + 1);
          jobs[selJob] = null;

          if (--remJobs == 0) {
            break;
          }
        }
      }
    }
  }
}

class Job {
  int l, r;

  public Job() {
    this.l = 0;
    this.r = 0;
  }
}
