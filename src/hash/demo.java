package src.hash;

import java.util.HashMap;
import java.util.List;

public class demo {
    public HashMap<String,Integer> map = new HashMap<>();

    public void update (String s, Integer i) {
        map.put(s,i);
    }

    public static void main(String args[]) {
        demo d = new demo();
        d.update("china", 6);
    }
}
