package src.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class D9_27 {
    // restaurants[i] = [id_i, rating_i, veganFriendly_i, price_i, distance_i]

    public static List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        int n = restaurants.length;
        List<int[]> filter = new ArrayList<>();
        for (int[] a:restaurants) {
            if (((veganFriendly == 0) || (veganFriendly == 1 && a[2] == 1)) && a[3] <= maxPrice && a[4] <= maxDistance) {
                filter.add(a);
            }
        }

        Collections.sort(filter,(a,b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            } else {
                return b[0] - a[0];
            }
        });

        List<Integer> ans = new ArrayList<>();
        for(int[] a: filter) {
            ans.add(a[0]);
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] restaurants = {{1,4,1,40,10},{2,8,0,50,5},{3,8,1,30,4},{4,10,0,10,3},{5,1,1,15,1}};
        System.out.println(filterRestaurants(restaurants, 1, 50, 10));
    }

}
