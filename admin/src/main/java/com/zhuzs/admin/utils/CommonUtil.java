package com.zhuzs.admin.utils;

import com.alibaba.fastjson.JSONObject;

import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * 公共函数类
 */
public class CommonUtil {


    /**
     * 验证邮箱是否正确
     *
     * @param email
     * @return
     */
    public static boolean isEmail(String email) {
        boolean flag = false;
        try {
            String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
            Pattern regex = compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 验证手机号是否正确
     *
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        boolean flag = false;
        try {
            Pattern pattern = compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
            Matcher m = pattern.matcher(mobile);
            flag = m.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }

    /**
     * 生成指定位数的随机字符串
     *
     * @param isNum  是否是纯数字
     * @param length 长度
     * @return
     */
    public static String getRandomStr(boolean isNum, int length) {
        String resultStr = "";
        String str = isNum ? "1234567890" : "1234567890abcdefghijkmnpqrstuvwxyz";
        int len = str.length();
        boolean isStop = true;
        do {
            resultStr = "";
            int count = 0;
            for (int i = 0; i < length; i++) {
                double dblR = Math.random() * len;
                int intR = (int) Math.floor(dblR);
                char c = str.charAt(intR);
                if (('0' <= c) && (c <= '9')) {
                    count++;
                }
                resultStr += str.charAt(intR);
            }
            if (count >= 2) {
                isStop = false;
            }
        } while (isStop);
        return resultStr;
    }

    /**
     * 判断是否在数组中
     *
     * @param s
     * @param array
     * @return
     */
    public static boolean inArray(final String s, final String[] array) {
        for (String item : array) {
            if (item != null && item.equals(s)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 从html中提取纯文本
     *
     * @param strHtml
     * @return
     */
    public static String stripHtml(String strHtml) {
        //剔出<html>的标签
        String content = strHtml.replaceAll("</?[^>]+>", "");
        //去除字符串中的空格,回车,换行符,制表符
        content = content.replaceAll("\\s*|\t|\r|\n", "");
        return content;
    }

    /**
     * 去除字符串中的空格、回车、换行符、制表符等
     *
     * @param str 原始字符串
     * @return
     */
    public static String replaceSpecialStr(String str) {
        String repl = "";
        if (str != null) {
            Pattern p = compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            repl = m.replaceAll("");
        }
        return repl;
    }

    /**
     * 判断是否是JSON格式
     *
     * @param str JSON字符串
     * @return
     */
    private boolean isJson(String str) {
        try {
            JSONObject jsonStr = JSONObject.parseObject(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * MD5方法
     *
     * @param source
     * @return
     */
    public static String md5(byte[] source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source);
            StringBuffer buf = new StringBuffer();
            for (byte b : md.digest()) {
                buf.append(String.format("%02x", b & 0xff));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 密码加密
     *
     * @param password 密码
     * @return
     */
    public static String password(String password) {
        String md51 = md5(password.getBytes());
        String pwd = md5((md51 + "IgtUdEQJyVevaCxQnY").getBytes());
        return pwd;
    }

}
