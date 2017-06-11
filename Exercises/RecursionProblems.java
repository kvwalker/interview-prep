public class RecursionProblems {

	public int countStairs (int n) {
		countStairs(n, new int[n + 1]);
	}

	public int countStairs (int n, int[] results) {
		// child can hop 1 step, 2 steps, or 3 steps at a time. how many ways can she run up the stairs?
		if (n <= 0) {
			return 0;
		}
		if (results[n] != 0) {
			return results[n];
		}
		if (n == 1 || n == 2) {
			results[n] = n;
		}
		results[n] = countStairs(n-1, results) + countStairs(n-2, results) + countStairs(n-3, results);
		return results[n];
	}

	public int magicIndex (int[] arr) {
		// find magic index if one exists in arr (A[i] = i) given sorted array of distinct integers
		// brute force
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == i) {
				return i;
			}
		}
		return -1;
		// binary search
		return magicSearch(arr, 0, arr.length - 1);
	}

	public int magicSearch (int[] arr, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = (start + end)/2;
		if (arr[mid] == mid) {
			return mid;
		} else if (arr[mid] > mid) {
			return magicSearch(arr, start, mid);
		} else {
			return magicSearch(arr, mid + 1, end);
		}
	}

	public static void main (String[] args) {

	}

}