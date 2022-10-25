class Solution {
    public int maxChunksToSorted(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int value : arr) {
          if (stack.isEmpty() || stack.peek() <= value) stack.push(value);
          else {
            int top = stack.pop();
            while (!stack.isEmpty() && stack.peek() > value) {
              stack.pop();
            }
            stack.push(top);
          }
        }
        return stack.size();
    }
}