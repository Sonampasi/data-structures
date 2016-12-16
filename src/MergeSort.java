import java.util.Scanner;

public class MergeSort {

	public void sort(int[] array) {

		int n = array.length;

		// if size of array is 2 then return
		if (n < 2) {
			return;
		}

		// calculate the middle point
		int mid = n / 2;

		// Create temp arrays
		int left[] = new int[mid];
		int right[] = new int[n - mid];

		// Copy data to temp arrays
		for (int i = 0; i < mid; i++) {
			left[i] = array[i];
		}
		for (int i = mid; i < n; i++) {
			right[i - mid] = array[i];
		}

		// Sort first and second halves
		sort(left);
		sort(right);

		// Merge the sorted halves
		merge(left, right, array);

	}

	/* Merge the temp arrays */

	public void merge(int[] left, int[] right, int[] array) {

		// size of first and second sub arrays
		int nLeft = left.length;
		int nRight = right.length;

		// Initial indexes of first and second sub arrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = 0;

		while ((i < nLeft) && (j < nRight)) {
			if (left[i] < right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			}
			k++;
		}

		// copy remaining elements of left array into the array
		while (nLeft > i) {
			array[k] = left[i];
			i++;
			k++;
		}

		// copy remaining elements of right array into the array
		while (nRight > j) {
			array[k] = right[j];
			j++;
			k++;
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		// enter the array size
		int n = s.nextInt();
		// initialize the array
		int array[] = new int[n];
		// enter elements in the array
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}

		MergeSort ms = new MergeSort();
		ms.sort(array);

		// print sorted array
		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
	}
}
