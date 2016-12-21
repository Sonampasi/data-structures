import java.util.Scanner;


public class QuickSort {
	
	int pIndex;//partition index
	int pivot;
	
	public void quickSort(int[] array, int start, int end){
		//termination condition
		if(start < end){
			pIndex = partition(array, start, end);
			quickSort(array, start, pIndex-1);
			quickSort(array, pIndex+1, end);			
		}
	}
	
	/*partitioning the array into 2 parts */
	
	public int partition(int[] array, int start, int end){
		//choose right most element of the array as pivot
		pivot = array[end];
		pIndex = start;
		int temp;
		for(int i = start; i < end; i++){
			if(array[i] <= pivot){
				//swap if element is lesser than pivot
				temp = array[i];
				array[i] = array[pIndex];
				array[pIndex] = temp;
				pIndex++;
			}
		}
		//swap pivot with element at pIndex
		temp = array[end];
		array[end] = array[pIndex];
		array[pIndex] = temp;
		//return partition index to quickSort method
		return pIndex;
	}
	
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		//enter the array size
		int n = s.nextInt();
		//initialize the array
		int array[] = new int[n];
		//enter elements in the array
		for(int i = 0; i < n; i++){
			array[i] = s.nextInt();
		}
		//sort array in ascending order
		for(int i = 0; i < n-1; i++ ){
			for(int j = i+1; j < n; j++){
				if(array[i] > array[j]){
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
		QuickSort qs = new QuickSort();
		//call quickSort method
		qs.quickSort(array, 0, n-1);// First index of the array is 0 and last index is n-1
		//print sorted array
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
	}

}
