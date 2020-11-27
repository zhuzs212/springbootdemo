package com.zhuzs.admin.zhuzsdemo;

import java.util.*;

/**
 * @description：TODO
 * @author: zhu_zishuang
 * @date: 2020-08-04
 */
public class Test {
    public static void main(String[] args) {
        // 1-35 1-12
//        Integer[] pass1 = {8, 11, 23, 26, 29, 34};
//        Integer[] pass2 = {1, 2, 4, 5, 6, 8};
//        List<Set<Integer>> result = generate(pass1, pass2);

        // 2,6,8,14,15,17,22,26,32,33
//        Integer[] integerArr1 = {1, 2, 3, 4, 5, 10, 11, 13, 15, 17, 19, 20, 21, 22, 23, 24, 28, 29, 31, 33, 35};
//        Integer[] integerArr2 = {2, 3, 4, 5, 6, 9};
//        List<Set<Integer>> result = generate2(integerArr1, integerArr2);
//
//
//        for (Set<Integer> set : result) {
//            System.out.println(set);
//        }

        System.out.println("结果1：" + 333334 % 23);
        System.out.println("结果2：" + 333334 / (333334 % 23));
    }

    public static List<Set<Integer>> generate(Integer[] pass1, Integer[] pass2) {
        // 结果
        List<Set<Integer>> result = new ArrayList<>();

        List<Integer> list1 = new ArrayList<>();
        for (int i = 1; i <= 35; i++) {
            list1.add(i);
        }
        // 过滤
        list1.removeAll(Arrays.asList(pass1));

        List<Integer> list2 = new ArrayList<>();
        for (int i = 1; i <= 12; i++) {
            list2.add(i);
        }
        // 过滤
        list2.removeAll(Arrays.asList(pass2));

        generateFinal(result, list1, list2);

        return result;
    }

    public static List<Set<Integer>> generate2(Integer[] integerArr1, Integer[] integerArr2) {
        // 结果
        List<Set<Integer>> result = new ArrayList<>();

        List<Integer> list1 = Arrays.asList(integerArr1);
        List<Integer> list2 = Arrays.asList(integerArr2);

        generateFinal(result, list1, list2);

        return result;
    }

    private static void generateFinal(List<Set<Integer>> result, List<Integer> list1, List<Integer> list2) {
        for (int i = 1; i < 2; i++) {
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
    }
}

