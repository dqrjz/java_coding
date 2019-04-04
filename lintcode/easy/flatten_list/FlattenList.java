package easy.flatten_list;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.
 * <p>
 * Notice:
 * If the element in the given list is a list, it can contain list too.
 * <p>
 * Example:
 * Given [1,2,[1,2]], return [1,2,1,2].
 * Given [4,[3,[2,[1]]]], return [4,3,2,1].
 * <p>
 * Challenge:
 * Do it in non-recursive.
 * <p>
 * This is the interface that allows for creating nested lists.
 * You should not implement it, or speculate about its implementation
 */
//public interface NestedInteger {
//  @return true if this NestedInteger holds a single integer, rather than a nested list.
//  public boolean isInteger();
//
//  @return the single integer that this NestedInteger holds, if it holds a single integer.
//  Return null if this NestedInteger holds a nested list.
//  public Integer getInteger();
//
//  @return the nested list that this NestedInteger holds, if it holds a nested list
//  Return null if this NestedInteger holds a single integer
//  public List<NestedInteger> getList();

public class FlattenList {
	/**
	 * Non-recursive method
	 * <p>
	 * This method is very important as it shows how to transform a recursive method to
	 * an alternate one using a while loop.
	 */
	public List<Integer> flatten(List<NestedInteger> nestedList) {
		if (nestedList == null) {
			return null;
		}
		List<Integer> result = new ArrayList<>();
		List<NestedInteger> list = nestedList;
		boolean isFlat = false; // indicates whether it is certain that list is flat
		while (!isFlat) {
			isFlat = true; // assume list is flat
			List<NestedInteger> newList = new ArrayList<>();
			for (NestedInteger nestedInteger : list) {
				if (nestedInteger.isInteger())
					newList.add(nestedInteger);
				else {
					// As long as list contains another sublist, we cannot be certain that list is flat.
					newList.addAll(nestedInteger.getList());
					isFlat = false;
				}
			}
			list = newList; // flatten list layer by layer
		}
		// Now list is completely flattened
		for (NestedInteger nestedInteger : list) {
			result.add(nestedInteger.getInteger());
		}
		return result;
	}
	
	/** Recursive method */
	public List<Integer> recursiveFlatten(List<NestedInteger> nestedList) {
		List<Integer> result = new ArrayList<>();
		if (nestedList == null) {
			return result;
		}
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger())
				result.add(nestedInteger.getInteger());
			else
				result.addAll(recursiveFlatten(nestedInteger.getList()));
		}
		return result;
	}
}
