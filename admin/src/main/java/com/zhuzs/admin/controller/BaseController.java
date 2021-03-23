package com.zhuzs.admin.controller;

import com.zhuzs.admin.exception.ServiceException;
import com.zhuzs.admin.comm.SysExceptionEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 基础控制类
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
public class BaseController {
    /**
     * 获取Excel输出数据流
     *
     * @param httpServletResponse http响应
     * @return 输出数据流
     * @author zhu_zishuang
     * @date 2020-12-03
     */
    protected OutputStream getExcelOutputStream(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setHeader("content-Type", "application/vnd.me-excel");
            httpServletResponse.setHeader("Content-Disposition", "attachment; filename=export.xlsx");
            return httpServletResponse.getOutputStream();
        } catch (IOException e) {
            throw new ServiceException(SysExceptionEnum.EXPORT_EXCEPTION);
        }
    }
}

