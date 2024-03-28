package com.demon.io.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @desc
 * @fileName ThreeNumAdd.java
 * @date 2024/1/25 14:46
 * @author Dongmo.Wu
 */
public class ThreeNumAdd {
	/*给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

	你返回所有和为 0 且不重复的三元组。

	注意：答案中不可以包含重复的三元组。

	示例 1：

	输入：nums = [-1,0,1,2,-1,-4]
	输出：[[-1,-1,2],[-1,0,1]]
	解释：
	nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
	nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
	nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
	不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
	注意，输出的顺序和三元组的顺序并不重要。*/
	/*
	*
	*
	*
	* */
	static class Key {
		public int first;
		public int second;
		public int third;

		@Override
		public boolean equals(Object o) {
			if (this == o)
				return true;
			if (o == null || getClass() != o.getClass())
				return false;
			Key key = (Key) o;
			boolean isEquals = (first == key.first && second == key.third && third == key.second)
					|| (first == key.second && second == key.first && third == key.third)
					|| (first == key.third && second == key.second && third == key.first)
					|| (first == key.second && second == key.third && third == key.first)
					|| (first == key.first && second == key.second && third == key.third);
			return isEquals;
		}

		@Override
		public int hashCode() {

			return first + second + third;
		}

		public Key(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}
	}
	public static void main(String[] args) {
		int [] nums = {-1,0,1,2,-1,-4};
		int length = nums.length;
		Map<Key, Long> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				for (int k = j + 1; k < length; k++) {
					long sum = (long) nums[i] + nums[j] + nums[k];
					if (sum == 0) {
						Key key = new Key(nums[i] , nums[j] , nums[k]);
						map.put(key, 0L);
					}
				}
			}

		}
		for (Map.Entry<Key, Long> keyLongEntry : map.entrySet()) {
			Key key = keyLongEntry.getKey();
			//System.out.println(arrs[key.first] + "," + arrs[key.second] + "," + arrs[key.third]);
			System.out.println(key.first + "," + key.second + "," + key.third);
		}
	}
}
