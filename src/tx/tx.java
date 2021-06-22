package tx;

import java.util.Stack;

public class tx {
    public static int[] findBuilding (int[] heights){
        int len  = heights.length;
        Stack<Integer> stack = new Stack<>();
        int[] rightLook = new int[len];
        int[] total = new int[len];
        for(int i = len - 1; i >= 0; i--){
            rightLook[i] = stack.size();
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
        }
        stack.clear();
        for(int i = 0; i < len; i++){
            total[i] = rightLook[i] + stack.size() + 1;
            while(!stack.isEmpty() && heights[i] >= heights[stack.peek()]){
                stack.pop();
            }
            stack.push(i);
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(findBuilding(new int[]{5, 3, 8, 3, 2, 5}));
    }
}
