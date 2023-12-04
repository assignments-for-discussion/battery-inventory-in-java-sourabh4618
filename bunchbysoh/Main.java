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
      double soh = (double) (presentCapacities[j] / ratedCapacity * 100);

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
    // Test case with present capacities
    int[] presentCapacities = {105, 90, 72, 50, 110};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);

    // Asserts to validate the counts
    assert counts.healthy == 2;
    assert counts.exchange == 1;
    assert counts.failed == 2;

    // Additional test cases with boundary conditions
    int[] edgeCase1 = {120};  // Single battery with maximum rated capacity
    CountsBySoH countsEdge1 = countBatteriesByHealth(edgeCase1);
    assert countsEdge1.healthy == 1;
    assert countsEdge1.exchange == 0;
    assert countsEdge1.failed == 0;

    int[] edgeCase2 = {0};  // Single battery with minimum present capacity
    CountsBySoH countsEdge2 = countBatteriesByHealth(edgeCase2);
    assert countsEdge2.healthy == 0;
    assert countsEdge2.exchange == 0;
    assert countsEdge2.failed == 1;
    
    System.out.println("Done counting :)\n");
  }
  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
