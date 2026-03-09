209. 长度最小的子数组
滑动窗口: 不断的调节子序列的起始位置和终止位置
class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        //外层 for：右指针不断向右扩展窗口
        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum >= target) {   //内层 while：当窗口和已经满足条件，就尝试缩小窗口
                result = Math.min(result, right - left + 1);//更新最短长度
                sum -= nums[left];//就可以拿它的长度和 result 比较。
                left++;
            }
        }

        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

for (right = 0 → n)

    add nums[right]

    while (window valid)
        update result
        shrink window

59.螺旋矩阵II

题目建议：  本题关键还是在转圈的逻辑，在二分搜索中提到的区间定义，在这里又用上了。 

题目链接：https://leetcode.cn/problems/spiral-matrix-ii/
文章讲解：https://programmercarl.com/0059.%E8%9E%BA%E6%97%8B%E7%9F%A9%E9%98%B5II.html
视频讲解：https://www.bilibili.com/video/BV1SL4y1N7mV/