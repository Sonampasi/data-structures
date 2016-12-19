import java.util.Scanner;

public class MergeSort {
	
	static int n;
	static int array[];
	
	/* read input */
	public boolean read(){
		Scanner s = new Scanner(System.in);
		// enter the array size
		n = s.nextInt();
		// initialize the array
		array = new int[n];
		// enter elements in the array
		for (int i = 0; i < n; i++) {
			array[i] = s.nextInt();
		}
		//check if array is already sorted
		for (int i = 1; i < n; i++) {
			if(array[i-1] > array[i]){
				return false;
			}
		}
		return true;
	}

	public void sort(int[] array) {
		
		//size of array
		int n = array.length;

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

		// Initial index of merged sub array
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

		MergeSort ms = new MergeSort();
		
		if(ms.read()){
			System.out.print("Array is already sorted in ascending order.");
		}
		else{
			System.out.print("Array has been sorted using merge sort.\n");
			//call sort method
			ms.sort(array);
			//print sorted array
			for (int i = 0; i < n; i++) {
				System.out.print(array[i] + " ");
			}
		}

	}
}
