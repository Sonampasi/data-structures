import java.util.Scanner;


public class sortArray {
	
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
		//print sorted array
		for(int i = 0; i < n; i++){
			System.out.print(array[i] + " ");
		}
	}
}
