344.

class Solution {
    public void reverseString(char[] s) {
        int l = 0;
        int r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
//交换必须用三步：temp = A， A = B， B = temp 否则数据会丢失

 541. 反转字符串II

class Solution {
    public String reverseStr(String s, int k) {

        // 字符串在 Java 中是不可修改的，所以先转换成 char 数组
        char[] arr = s.toCharArray();

        // 每次移动 2k 个位置
        // i 表示每一组的起始位置
        for (int i = 0; i < arr.length; i += 2 * k) {

            // 要反转的部分从 i 开始
            int left = i;

            // 反转到 i+k-1 位置
            // 如果剩余字符不足 k 个，就反转到数组末尾
            int right = Math.min(i + k - 1, arr.length - 1);

            // 双指针交换字符，实现反转
            while (left < right) {

                // 保存左边字符
                char temp = arr[left];

                // 右边字符放到左边
                arr[left] = arr[right];

                // 左边字符放到右边
                arr[right] = temp;

                // 左指针向右移动
                left++;

                // 右指针向左移动
                right--;
            }
        }

        // 再把 char 数组转换回字符串
        return new String(arr);
    }
}