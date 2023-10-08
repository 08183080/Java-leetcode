package src.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class L187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hash = new HashMap<>();
        List<String> ans = new ArrayList<String>(); // 记住这个初始化方式...
        int n = s.length();
        for (int i = 0; i <= n-10; i++) {
            String temp = s.substring(i, i+10);
            int cnt = hash.getOrDefault(temp, 0);
            hash.put(temp,++cnt);
            if (cnt == 2)   ans.add(temp);
        }
        return ans;
    }

    public static void main(String args[]) {
        L187 d = new L187();
        List<String> list = d.findRepeatedDnaSequences("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        for (String s:list) {
            System.out.println(s);
        }
    }

}
