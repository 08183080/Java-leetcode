package src.Monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
    Deque<int[]> stack; // 栈
    int id;

    public StockSpanner() {
        stack = new ArrayDeque<int[]>();
        stack.push(new int[]{-1, Integer.MAX_VALUE});
        id = -1;
    }

    public int next(int price){
        id++;
        while (stack.peek()[1] <= price) {
            stack.pop();
        }
        int d = id - stack.peek()[0];
        stack.push(new int[]{id, price});
        return d;
    }
}
