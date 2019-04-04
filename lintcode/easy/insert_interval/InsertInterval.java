package easy.insert_interval;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Given a non-overlapping interval list which is sorted by start point.
 * <p>
 * Insert a new interval into it, make sure the list is still in order and non-overlapping (merge intervals if
 * necessary).
 * <p>
 * Example:
 * Insert [2, 5] into [[1,2], [5,9]], we get [[1,9]].
 * Insert [3, 4] into [[1,2], [5,9]], we get [[1,2], [3,4], [5,9]].
 */
public class InsertInterval {
	public static void main(String[] args) {
		/*Interval i1 = new Interval(1, 2);
		Interval i2 = new Interval(5, 9);
		List<Interval> intervals = new ArrayList<>();
		intervals.add(i1);
		intervals.add(i2);
		
		Interval newI1 = new Interval(2, 5);
		Interval newI2 = new Interval(3, 4);
		
		List<Interval> newIntervals1 = insert(intervals, newI1);
		StringBuilder res1 = new StringBuilder("[");
		for (Interval interval : newIntervals1)
			res1.append("[").append(interval.start).append(",").append(interval.end).append("],");
		res1.setCharAt(res1.lastIndexOf(","), ']');
		System.out.println(res1.toString());
		
		List<Interval> newIntervals2 = insert(intervals, newI2);
		StringBuilder res2 = new StringBuilder("[");
		for (Interval interval : newIntervals2)
			res2.append("[").append(interval.start).append(",").append(interval.end).append("],");
		res2.setCharAt(res2.lastIndexOf(","), ']');
		System.out.println(res2.toString());*/
		Random random = new Random();
		for (int i = 0; i < 3; i++) {
			System.out.println("第" + (random.nextInt(3) + i * 3 + 1) + "位");
		}
	}
	
	/** Correct method */
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (intervals == null || newInterval == null) {
			return intervals;
		}
		int insertPos = 0;
		List<Interval> res = new ArrayList<>();
		
		for (Interval interval : intervals) {
			if (newInterval.start > interval.end) {
				res.add(interval);
				insertPos++;
			} else if (newInterval.end < interval.start)
				res.add(interval);
			else {
				newInterval.start = Math.min(interval.start, newInterval.start);
				newInterval.end = Math.max(interval.end, newInterval.end);
			}
		}
		res.add(insertPos, newInterval);
		return res;
	}
}

/** Definition of Interval */
class Interval {
	int start, end;
	
	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
