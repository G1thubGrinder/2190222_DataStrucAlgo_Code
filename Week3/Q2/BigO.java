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
	
//	public static List<List<Integer>> m2Version2(int[] nums) { // O(n^2)
//        List<List<Integer>> result = new ArrayList<>();
//        ArrayList<Integer> numbers = new ArrayList<>();
//        for(int i = 0; i < nums.length; i++) {
//        	numbers.add(nums[i]);
//        }
//        for(int i = 0; i < nums.length - 1; i++) {
//        	for(int j = i + 1; j < nums.length; j++) {
//        		int target = -nums[i]-nums[j];
//        		if(numbers.contains(target)) {
//        			List<Integer> triplet = Arrays.asList(nums[i], nums[j], target);
//        			Collections.sort(triplet);
//        			if(!result.contains(triplet)) {
//        				result.add(triplet);
//        			}
//        		}
//        	}
//        }
//        return result;
//   }
	public List<List<Integer>> m2Version2z(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    // Found a triplet with zero sum
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // Skip duplicate elements for j
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }

                    // Skip duplicate elements for k
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }

                    // Move the pointers
                    j++;
                    k--;
                } else if (sum < 0) {
                    // Sum is less than zero, increment j to increase the sum
                    j++;
                } else {
                    // Sum is greater than zero, decrement k to decrease the sum
                    k--;
                }
            }
        }
        return ans;
    }

}
