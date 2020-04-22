package com.zhuzs.common;

import java.math.BigDecimal;

/**
 * @description：常量类
 * @author: zhu_zishuang
 * @date: 2020-04-22 14:22
 */
public interface Constant {

    /**
     * 返回结果 success：成功，fail：业务返回的失败，error：非业务异常失败
     */
    interface ReqResult {
        String SUCCESS = "success";
        String FAIL = "fail";
        String ERROR = "error";
    }


    /**
     * 常用数值
     */
    interface Number {
        Integer MINUS_ZERO = -1;
        Integer ZERO = 0;
        Integer ONE = 1;
        Integer TWO = 2;
        Integer THREE = 3;
        Integer FOUR = 4;
        Integer FIVE = 5;
        Integer SIX = 6;
        Integer SEVEN = 7;
        Integer EIGHT = 8;
        Integer NINE = 9;
        Integer TEN = 10;
        Integer TWENTYFIVE = 25;
        Integer THIRTYTHREE = 33;
        Integer FOURTY = 40;
        Integer LENGTH = 3;
        Integer NINETYNINE = 99;
        Integer ONEHUNDRED = 100;
        Long ZEROL = 0L;
        Long ONEL = 1L;
        Long COMPANY = 2L;
        Long BUSINESS = 3L;
        Long ONETHOUSANDL = 1000L;
        Byte ONEB = 1;
        Byte TWOB = 2;
        Byte THREEB = 3;
        Byte ANTI_INITLIZED = 0;
        Byte INITLIZED = 1;
        Double ZBXS = 0.01;
        BigDecimal ZEROB = new BigDecimal(0);
        BigDecimal ZEROBXS = new BigDecimal(0.00);
        BigDecimal HUNDRED = new BigDecimal(100.00);
        Double ZEROD = 0D;
    }


    /**
     * 常用字符
     */
    interface Character {
        String GROUP_CODE = "0000";
        String QUESTION = "?";
        String EQUALS = "=";
        String AND = "&";
        String COLON = ":";
        String ASTERISK = "*";
        String POINT = ".";
        String COMMA = ",";
        String BRACKET_LEFT_B = "{";
        String BRACKET_RIGHT_B = "}";
        String ZERO = "00";
        String ONE = "001";
        String String_ZERO = "0";
        String NULL_VALUE = "";
        String UNDER_LINE = "_";
        String MIDDLE_LINE = "-";
        String VIRGULE = "/";
        Byte FAIL = 0;
        Byte SUCCESS = 1;
        Byte IS_REFERENCE = 2;
        String Percent = "%";
        String UTF8 = "utf-8";
        String HASH_SIGN = "#";
        String COMMA_SINGLE_QUOTE_SEPERATOR = "','";
        String DOUBLE_COMMA = ",,";
        String ON = "ON";
        String OFF = "OFF";
        String TIP_FLAG = "tipFlag";
    }


    /**
     * 是否
     */
    interface Is {
        Byte YES = 1;
        Byte NO = 0;
        Integer YES_INT = 1;
    }


    /**
     * session时效
     */
    interface GetSessionTime {
        int SESSION_TIME_2H = 60 * 60 * 2;
    }


    /**
     * 正则表达式常量
     */
    interface RegExp {
        /**
         * 括号，包括大括号和小括号
         */
        String BRACKETS = "\\{|\\}|\\(|\\)";
        /**
         * 不可见字符
         */
        String INVISIBLE = "\\s";
        /**
         * 运算符 加减乘除
         */
        String OPERATOR = "\\+|\\-|\\*|\\/";
        /**
         * 数字，包括整形和浮点型
         */
        String NUMBER = "'(\\d|\\.)+'";
        /**
         * 逗号开头或结尾
         */
        String COMMA_START_OR_END = "^,|,$";
        /**
         * 井号左括号
         */
        String HASH_SIGN_BRACKET_LEFT = "#\\{";
        /**
         * 右括号
         */
        String BRACKET_RIGHT = "\\}";
        /**
         * #{内容}，占位符内容
         */
        String PLACE_HOLDER_CONTENT = "#\\{([^}])*\\}";
        /**
         * #{参数map.
         */
        String PLACE_HOLDER_PARAM_MAP = "#\\{paramMap.";
        /**
         * 井号或者大括号
         */
        String HASH_SIGN_BRACKETS = "#|\\{|\\}";
        /**
         * 空请求体
         */
        String EMPTY_REQUEST_BODY = "\\{\\s+\\}";

    }

}
