package src.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Priority_queue {
    public static void main (String args[]) {
        PriorityQueue queue = new PriorityQueue();  //Min-heap
//        PriorityQueue queue1 = new PriorityQueue(Comparator.reverseOrder());    //Max-heap
        queue.add(20);
        queue.add(12);
        queue.add(18);
        System.out.println(queue.peek());   //12
        queue.poll();
        System.out.println(queue.peek());   //18
        queue.poll();
        System.out.println(queue.peek());   //20
    }
}
