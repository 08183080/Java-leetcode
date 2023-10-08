package src.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StockPrice {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();    // 哈希【键值对 关联数组】
    TreeMap<Integer,Integer> ts = new TreeMap<Integer, Integer>();  // 红黑树【键值对, 关联数组】 自带排序属性
    int cur;        // 当前最大元素

    public void update(int timestamp, int price) {
        cur = Math.max(cur, timestamp);
        // map中含有timestamp时候
        if (map.containsKey(timestamp)) {
            int value = map.get(timestamp);
            int cnt = ts.get(value);
            if (cnt == 1) {
                ts.remove(value);
            } else {
                ts.put(value, cnt - 1);
            }
        }
        map.put(timestamp, price);
        ts.put(price, ts.getOrDefault(price ,0) + 1);
    }

    public int current() {
        return map.get(cur);
    }

    public int maximum() {
        return ts.lastKey();
    }

    public int minimum() {
        return ts.firstKey();
    }

    public static void main(String args[]) {
        StockPrice s = new StockPrice();
        s.update(1, 2);
        s.update(2, 3);
        s.update(4,8);
        System.out.println(s.current());
        System.out.println(s.maximum());
        System.out.println(s.minimum());
    }
}
