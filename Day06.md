Day06 Hash table
leetcode 242.
two loop, time is O
Key Idea

Use a hash array to count characters, Since the problem only contains lowercase English letters:
we can use an array of size 26.
s[i] - 'a'
这是把 字母转成数组下标。
Method

Traverse string s, count each character
Traverse string t, subtract each character
If all counts are 0, they are anagrams

/**
 * 242. 有效的字母异位词 字典解法
 * 时间复杂度O(m+n) 空间复杂度O(1)
 */
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];

        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;     // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了 统计每个字母出现次数
        }

        for (int i = 0; i < t.length(); i++) { // 把 t 中的字母数量减掉
            record[t.charAt(i) - 'a']--;
        }
        
        for (int count: record) {
            if (count != 0) {               // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
                return false;
            }
        }
        return true;                        // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}

349. 两个数组的交集
number1 进行处理转成hash table的形式，在number 2 里面看是否出现过，出现过放进result 里面
// 时间复杂度O(n+m+k) 空间复杂度O(n+k)
// 其中n是数组nums1的长度，m是数组nums2的长度，k是交集元素的个数

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> resSet = new HashSet<>();
        //遍历数组1
        for (int i : nums1) {
            set1.add(i);
        }
        //遍历数组2的过程中判断哈希表中是否存在该元素
        for (int i : nums2) {
            if (set1.contains(i)) {
                resSet.add(i);
            }
        }
      
        //方法1：将结果集合转为数组
        return res.stream().mapToInt(Integer::intValue).toArray();
        /**
         * 将 Set<Integer> 转换为 int[] 数组：
         * 1. stream() : Collection 接口的方法，将集合转换为 Stream<Integer>
         * 2. mapToInt(Integer::intValue) : 
         *    - 中间操作，将 Stream<Integer> 转换为 IntStream
         *    - 使用方法引用 Integer::intValue，将 Integer 对象拆箱为 int 基本类型
         * 3. toArray() : 终端操作，将 IntStream 转换为 int[] 数组。
         */
        
        //方法2：另外申请一个数组存放setRes中的元素,最后返回数组
        int[] arr = new int[resSet.size()];
        int j = 0;
        for(int i : resSet){
            arr[j++] = i;
        }
        
        return arr;
    }
}
202
Algorithm

Create a HashSet

Repeat:

calculate square sum

check if number already exists in set

If result becomes 1 → return true

1 sum 
什么时候使用哈希法，当我们需要查询一个元素是否出现过，或者一个元素是否在集合里的时候，就要第一时间想到哈希法。
使用 key value结构来存放，key来存元素，value来存下标
//使用哈希表
public int[] twoSum(int[] nums, int target) {
    int[] res = new int[2]; //创建一个长度为2的数组
    if(nums == null || nums.length == 0){
        return res;
    }
    Map<Integer, Integer> map = new HashMap<>();  //key   = 数值,value = 下标
    for(int i = 0; i < nums.length; i++){
        int temp = target - nums[i];   // 遍历当前元素，并在map中寻找是否有匹配的key意思是：
        //当前数字需要一个 搭档。
        //target = 9, nums[i] = 7, temp = 9 - 7 = 2,意思：我需要找到 2
        if(map.containsKey(temp)){
            res[1] = i;
            res[0] = map.get(temp);
            break;
        }
        map.put(nums[i], i);    // 如果没找到匹配对，就把访问过的元素和下标加入到map中
    }
    return res;
}