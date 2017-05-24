/*Given an array of integers, return indices of the two numbers such that they add up to a specific target.
*You may assume that each input would have exactly one solution, and you may not use the same element twice.
*Time complexity - O(n)
*/
import java.util.HashMap;
import java.util.Map;

public class TwoSumUsingHashTable {
	public int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	        int complement = target - nums[i];
	        if (map.containsKey(complement)) {
	            return new int[] { map.get(complement), i };
	        }
	        map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("No two sum solution");
	}
	public static void main(String[] args){
		TwoSumUsingHashTable obj = new TwoSumUsingHashTable();
		int[] nums = {2,7,11,15};
		obj.twoSum(nums,9);
	}
}
