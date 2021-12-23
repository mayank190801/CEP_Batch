public class questions {
    // Long pressed name
    public boolean isLongPressedName(String name, String typed) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < name.length() && p2 < typed.length()) {
            if (name.charAt(p1) == typed.charAt(p2)) {
                p1++;
                p2++;
            } else {
                if (p2 == 0 || typed.charAt(p2) != typed.charAt(p2 - 1)) {
                    return false;
                }
                while (p2 < typed.length() - 1 && typed.charAt(p2) == typed.charAt(p2 + 1)) {
                    p2++;
                }
                p2++;
            }
        }
        if (p2 == typed.length() && p1 != name.length()) {
            return false;
        }
        if (p1 == name.length()) {
            while (p2 < typed.length() && typed.charAt(p2 - 1) == typed.charAt(p2)) {
                p2++;
            }
        }
        return p2 == typed.length();
    }

    // CONTAINER WITH MOST WATER

    public int maxArea(int[] height) {
        int ans = 0;
        int si = 0;
        int ei = height.length - 1;
        while (si < ei) {
            ans = Math.max(ans, Math.min(height[si], height[ei]) * (ei - si));
            if (height[si] < height[ei]) {
                si++;
            } else {
                ei--;
            }
        }
        return ans;
    }

    // SQUARE
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        int p1 = 0;
        int p2 = len - 1;
        int p = len - 1;
        while (p1 <= p2) {
            int s1 = nums[p1] * nums[p1];
            int s2 = nums[p2] * nums[p2];
            if (s2 >= s1) {
                ans[p] = s2;
                p2--;
            } else {
                ans[p] = s1;
                p1++;
            }
            p--;
        }
        return ans;
    }

    // NEXT PERMUTATION

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            reverse(nums, 0, len - 1);
            return;
        }

        int j = len - 1;
        while (j > i && nums[j] <= nums[i]) {
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i + 1, len - 1);
    }

    public void swap(int[] nums, int i, int j) {
        nums[j] = ((nums[i] + nums[j]) - (nums[i] = nums[j]));
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    // PREV PERMUTATION WITH ONE SWAP

    public int[] prevPermOpt1(int[] nums) {
        int len = nums.length;
        int i = nums.length - 2;
        while (i >= 0 && nums[i] <= nums[i + 1]) {
            i--;
        }
        if (i == -1) {
            return nums;
        }

        int j = len - 1;
        while (j > i && (nums[j] >= nums[i] || nums[j - 1] == nums[j])) {
            j--;
        }
        swap(nums, i, j);
        return nums;
    }

    // MAXIMUM SWAP

    public int maximumSwap(int num) {
        char[] arr = Integer.toString(num).toCharArray();
        int[] digmap = new int[10];
        for (int i = 0; i < arr.length; i++) {
            digmap[arr[i] - '0'] = i;
        }
        for (int i = 0; i < arr.length; i++) {
            int dig = arr[i] - '0';
            for (int j = 9; j > dig; j--) {
                if (digmap[j] > i) {
                    int idx = digmap[j];
                    char t = arr[i];
                    arr[i] = arr[idx];
                    arr[idx] = t;
                    return Integer.parseInt(String.valueOf(arr));
                }
            }
        }
        return num;
    }

    // MAX CHUNK 1
    public int maxChunksToSorted(int[] arr) {
        int ans = 0;
        int maxchunk = -1;
        for (int i = 0; i < arr.length; i++) {
            if (i > maxchunk) {
                ans++;
                maxchunk = arr[i];
            } else {
                maxchunk = Math.max(maxchunk, arr[i]);
            }
        }
        return ans;
    }
}