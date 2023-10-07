package src.Monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class monotonic_stack {
    Deque<Integer> stack;
    // 实现一个简单的递增单调栈

    public monotonic_stack(){
        stack = new ArrayDeque<>();
    }

    /*
    * 单调栈的 增删查改 CRUD
    *  1. 增. 增的时候可能有附加删的操作.
    *  2. 删. pop()方法,一次只能删除栈顶的元素
    *  3. 查. peek()方法,一次只能查询栈顶的元素
    *  4. 改. 体现在增,删上面
    * */

    public void add(int num) {
        // 大于等于num的元素都弹出...
        while(!stack.isEmpty() && stack.peek() >= num) {
            int temp = stack.pop();
            System.out.printf("弹出元素%d\n", temp);
        }
        stack.push(num);
        System.out.printf("插入元素%d\n",num);
    }

    public static void main(String args[]) {
        monotonic_stack stack1 = new monotonic_stack();
        stack1.add(1);
        stack1.add(4);
        stack1.add(6);
        stack1.add(3);
        stack1.add(8);
        stack1.add(99);
        stack1.add(66);
    }
}
