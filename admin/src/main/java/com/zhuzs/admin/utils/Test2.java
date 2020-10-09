package com.zhuzs.admin.utils;

import java.util.*;

/**
 * @description：TODO
 * @author: zhu_zishuang
 * @date: 2020-08-04
 */
public class Test2 {
    public static void main(String[] args) {
//        // 1-33 1-16
//        // 2 9 10 21 35 1 7
//        Integer[] pass1 = {};
//
//        Integer[] pass2 = {1, 2, 3, 4, 5, 6, 7};
//
//        List<Set<Integer>> result = generate(pass1, pass2);
//        for (Set<Integer> set : result) {
//            System.out.println(set);
//        }


        Double d1 = 13.0;
        Double d2 = 3.2;
        System.out.println(d1 / d2);
    }

    public static List<Set<Integer>> generate(Integer[] pass1, Integer[] pass2) {
        // 结果
        List<Set<Integer>> result = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 33; i++) {
            list1.add(i);
        }
        // 过滤
        list1.removeAll(Arrays.asList(pass1));

        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 16; i++) {
            list2.add(i);
        }
        // 过滤
        list2.removeAll(Arrays.asList(pass2));
        System.out.println("list2,过滤后： " + list2.toString());

        for (int i = 1; i < 6; i++) {
            Set<Integer> QQ = new TreeSet<>();
            Set<Integer> HQ = new TreeSet<>();
            // qian
            while (QQ.size() < 5) {
                int index = new Random().nextInt(list1.size());
                QQ.add(list1.get(index));
            }
            //hou
            while (HQ.size() < 2) {
                int index = new Random().nextInt(list2.size());
                HQ.add(list2.get(index));
            }
            result.add(QQ);
            result.add(HQ);
        }

        return result;
    }
}

