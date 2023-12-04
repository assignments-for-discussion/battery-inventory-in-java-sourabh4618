package bunchbysoh;



public class Main {
    static class CountsBySoH {
        public int healthy = 0;
        public int exchange = 0;
        public int failed = 0;
    }

    static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
      CountsBySoH counts = new CountsBySoH();

      // Rated capacity of a new battery
      int ratedCapacity = 120;

      for (int j=0;j<presentCapacities.length;j++) {
            
        // Compute SoH percentage
        double soh = (double) ((presentCapacities[j] / ratedCapacity) * 100);

        // Classify batteries based on SoH
        if (soh >= 80 && soh <= 100) {
          counts.healthy++;
        } else if (soh >= 62 && soh < 80) {
          counts.exchange++;
        } else {
          counts.failed++;
        }
      }
      return counts;
    }

    static void testBucketingByHealth() {
      System.out.println("Counting batteries by SoH...\n");
      //sample test cases
      int[] presentCapacities = {113, 116, 80, 95, 92, 70, 60};           
      CountsBySoH counts = countBatteriesByHealth(presentCapacities);
      assert(counts.healthy == 2);
      assert(counts.exchange == 3);
      assert(counts.failed == 2);
      System.out.println("Done counting :)\n");
    }
    public static void main(String[] args) {
      testBucketingByHealth();
    }
}

