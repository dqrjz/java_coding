package easy.search_a_2d_matrix;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * <p>
 * This matrix has the following properties:
 * 1. Integers in each row are sorted from left to right.
 * 2. The first integer of each row is greater than the last integer of the previous row.
 * <p>
 * Example:
 * Consider the following matrix:
 * [
 * [   1,  3,  5,  7   ],
 * [   10, 11, 16, 20  ],
 * [   23, 30, 34, 50  ]
 * ]
 * Given target = 3, return true.
 * <p>
 * Challenge:
 * O(log(n) + log(m)) time
 */
public class SearchA2DMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		for (int[] ints : matrix) {
			for (int anInt : ints) {
				System.out.print(anInt + "\t");
			}
			System.out.println();
		}
		int target = 5;
		boolean flag = searchMatrix(matrix, target);
		System.out.println(flag);
	}
	
	/**
	 * Binary Search Once
	 * Treat the 2D Matrix as one continuous sorted array displayed in several lines.
	 *
	 * @param matrix matrix, a list of lists of integers
	 * @param target An integer
	 * @return a boolean, indicate whether matrix contains target
	 */
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) return false;
		if (matrix[0] == null || matrix[0].length == 0) return false;
		
		int rows = matrix.length;
		int columns = matrix[0].length;
		
		int start = 0;
		int end = rows * columns - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			int midNum = matrix[mid / columns][mid % columns];
			if (target < midNum)
				end = mid - 1;
			else if (target > midNum)
				start = mid + 1;
			else
				return true;
		}
		return false;
	}
}
