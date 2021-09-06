package com.leetcode.basic.priorityqueue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ZenGx1n
 * @since 2021-09-02 11:23
 */
public class Solution973 {

    class Point {
        int index;
        int[] point;

        public Point(int index, int[] point) {
            this.index = index;
            this.point = point;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        Double[] dis = new Double[points.length];
        int m = 0;
        for (int[] point : points) {
            dis[m++] = Math.sqrt(point[0] * point[0] + point[1] * point[1]);
        }
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.comparing(o -> dis[o.index]));
        for (int i = 0; i < points.length; i++) {
            pq.add(new Point(i, points[i]));
        }
        int[][] res = new int[k][2];
        int cnt = 0;
        while (cnt < k) {
            res[cnt++] = pq.remove().point;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution973 solution = new Solution973();
        int[][] points = solution.kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        System.out.println(Arrays.deepToString(points));
    }

}
