class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] list = new int[arr.length + 1];

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int num : map.values()) {
            list[num] ++;
        }

        int steps = 0, res = 0;
        for (int i = arr.length; i > 0; i--) {
            int cur = list[i];
            while (cur > 0) {
                steps += i;
                res++;
                if (steps >= arr.length/2)
                    return res;
                cur--;
            }
        }
        return arr.length;
    }
}