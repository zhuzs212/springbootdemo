package com.zhuzs.admin.comm;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * EasyExcel自定义Converter解决LocalDateTime日期转换
 *
 * @author zhu_zishuang
 * @date 2021-03-12
 */
public class LocalDateTimeConverter implements Converter<LocalDateTime> {

    private final String dateFormat;

    public LocalDateTimeConverter(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public Class supportJavaTypeKey() {
        return LocalDateTime.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    @Override
    public LocalDateTime convertToJavaData(CellData cellData, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(cellData.getStringValue(), dateTimeFormatter);
        return LocalDateTime.of(localDate, LocalTime.of(0, 0));
    }

    @Override
    public CellData convertToExcelData(LocalDateTime localDateTime, ExcelContentProperty contentProperty, GlobalConfiguration globalConfiguration) throws Exception {
        return new CellData(localDateTime.format(DateTimeFormatter.ofPattern(this.dateFormat)));
    }
}

