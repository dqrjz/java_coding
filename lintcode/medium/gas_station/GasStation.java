package medium.gas_station;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to
 * its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p>
 * Notice:
 * The solution is guaranteed to be unique.
 * <p>
 * Example:
 * Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1].
 * The starting gas station's index is 2.
 * <p>
 * Challenge:
 * O(n) time and O(1) extra space
 */
public class GasStation {
	public static void main(String[] args) {
		int[] gas = {1, 1, 3, 1};
		int[] cos = {2, 2, 1, 1};
		System.out.println(canCompleteCircuit(gas, cos));
		System.out.println(canCompleteCircuit2(gas, cos));
	}
	
	/**
	 * Better method
	 * O(n) time and O(1) extra space
	 *
	 * @param gas  An array of integers
	 * @param cost An array of integers
	 * @return An integer
	 */
	public static int canCompleteCircuit2(int[] gas, int[] cost) {
		if (gas == null || cost == null || gas.length == 0 || cost.length == 0) {
			return -1;
		}
		
		int index = -1;
		int sum = 0;
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			sum += gas[i] - cost[i];
			total += gas[i] - cost[i];
			if (sum < 0) {
				index = i;
				sum = 0;
			}
		}
		return (total < 0) ? -1 : index + 1;
	}
	
	/**
	 * My original method
	 * O(n^2) time
	 *
	 * @param gas  An array of integers
	 * @param cost An array of integers
	 * @return An integer
	 */
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		// write your code here
		int len = gas.length;
		for (int i = 0; i < len; i++) {
			int gasInTank = 0;
			boolean canComplete = true;
			for (int j = i; j < i + len; j++) {
				int index = (j < len) ? j : j % len;
				gasInTank = gasInTank + gas[index] - cost[index];
				if (gasInTank < 0) {
					canComplete = false;
					break;
				}
			}
			if (canComplete)
				return i;
		}
		return -1;
	}
}
