package com.zhuzs.admin.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.zhuzs.admin.comm.LocalDateTimeConverter;

import java.io.OutputStream;
import java.util.List;

/**
 * Excel工具类
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
public final class ExcelUtil {
    private ExcelUtil() {
    }

    public static <T> void writeExcel(OutputStream outputStream, List<T> list, Class<T> clss) {
        writeExcel(outputStream, list, clss, "yyyy-MM-dd");
    }

    private static <T> void writeExcel(OutputStream outputStream, List<T> list, Class<T> clss, String dateFormat) {
        EasyExcelFactory.write(outputStream, clss).registerConverter(new LocalDateTimeConverter(dateFormat)).sheet().doWrite(list);
    }

}

