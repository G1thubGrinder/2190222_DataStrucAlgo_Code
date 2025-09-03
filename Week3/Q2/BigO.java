package HW.Week3.Q2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BigO {
	public static boolean m1(int[] arr) { // O(n^2)
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean m1Version2(int[] arr) { //O(n)
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 0; i < arr.length; i++) {
        	hs.add(arr[i]);
        }
		return !(arr.length == hs.size());
	}

	public static List<List<Integer>> m2(int[] nums) { //O(n^3)
		List<List<Integer>> result = new ArrayList<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				for (int k = j + 1; k < n; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
						Collections.sort(triplet); // avoid duplicates
						if (!result.contains(triplet)) {
							result.add(triplet);
						}
					}
				}
			}
		}

		return result;
	}
	
	public static List<List<Integer>> m2Version2(int[] nums) { // O(n^2)
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; ++i) {
        	if(i > 0 && nums[i] == nums[i - 1]) continue;
        	
        	int l = i + 1; int r = nums.length - 1;
        	while(l < r) {
        		int summ = nums[i] + nums[l] + nums[r];
        		if(summ == 0) {
        			List<Integer> triplet = Arrays.asList(nums[i], nums[l], nums[r]);
        			result.add(triplet);
        			int l_value = nums[l]; int r_value = nums[r];
        			while(nums[l] == l_value) l++;
        			while(nums[r] == r_value) r--;
        		}
        		else if(summ > 0)r--;
        		else l++;
        	}
        }
        return result;
   }

}
