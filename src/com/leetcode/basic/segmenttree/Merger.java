package com.leetcode.basic.segmenttree;

/**
 * @author ZenGx1n
 * @since 2021-09-03 9:17
 */
public interface Merger<E> {

    E merge(E a, E b);

}