package com.zhuzs.admin.zhuzsdemo;

import com.zhuzs.admin.entity.domain.UserDO;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 校验List<UserDO>的对象orgNo是否有重复，有重复true
 *
 * @author zhu_zishuang
 * @date 2020-12-02
 */
public class ListItemParamCheck {
    public static boolean checkOrgNoUnique(List<UserDO> userDOList) {
        // TODO lambda表达式
        Set<UserDO> set = new TreeSet<>(
                Comparator.comparing(UserDO::getOrgNo)
        );
        set.addAll(userDOList);
        if (set.size() < userDOList.size()) {
            return true;
        }
        return false;
    }

    /**
     * TODO 流、链式编程
     *
     * @param userDOList
     * @return
     */
    public static boolean checkOrgNoUnique2(List<UserDO> userDOList) {
        long existTotal = userDOList.stream().collect(Collectors.groupingBy(UserDO::getOrgNo, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).map(Map.Entry::getKey).count();
        return existTotal > 0;
    }
}

class test {

    public static void main(String[] args) {
        List<UserDO> list = new ArrayList<>();
        UserDO u1 = new UserDO();
        u1.setOrgNo("123");
        UserDO u2 = new UserDO();
        u2.setOrgNo("123");
        UserDO u3 = new UserDO();
        u3.setOrgNo("456");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        boolean flag = ListItemParamCheck.checkOrgNoUnique(list);
        System.out.println("flag:" + flag);
    }
}

