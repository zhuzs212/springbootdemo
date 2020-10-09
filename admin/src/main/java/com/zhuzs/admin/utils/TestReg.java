package com.zhuzs.admin.utils;

import com.zhuzs.admin.common.ExceptionConstantEnum;
import com.zhuzs.admin.exception.ServiceException;

/**
 * @description：TODO
 * @author: zhu_zishuang
 * @date: 2020-09-16
 */
public class TestReg {
    public static void main(String[] args) {
        String reg = "_";
        String str = "123_zhuzs-test";
        if(str.contains(reg)){
            throw new ServiceException(ExceptionConstantEnum.PARAMS_NOT_RIGHT);
        }


        String reg_ = "^[0-9a-zA-Z]{0,20}$";
        String str_ = "";
        System.out.println(str_.matches(reg_));
    }
}

