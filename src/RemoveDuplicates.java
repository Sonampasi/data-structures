/* 
 * Remove Duplicates from Sorted Array
 * Time complexity O(n)
 */
public class RemoveDuplicates {
	
	public int removeDuplicates(int[] nums) {
        int[] array = nums;
		int repeated = 0;
		int len = 0;
		if(array.length<2){
			return array.length;
		}
		len = 1;
        for(int i = 1; i < array.length; i++){
        	
			if(array[i-1]==array[i]){
				repeated++;
			}
			else if(repeated>=1 && array[i-1]<array[i]){
				array[i-repeated]=array[i];
				len++;
			}else{
				len++;
			}
		}
       
		return len;
    }
	public static void main(String[] args){
		RemoveDuplicates rd = new RemoveDuplicates();
		int[] nums = {1,2,2,4}; 
		System.out.println(rd.removeDuplicates(nums));
	}
}
