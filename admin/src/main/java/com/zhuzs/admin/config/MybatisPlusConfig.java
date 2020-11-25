package com.zhuzs.admin.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import com.zhuzs.common.Constant;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * 配置mybatisPlus插件
 *
 * @author xyyxhcj@qq.com
 * @since 2018-08-25
 */
@EnableTransactionManagement
@SpringBootConfiguration
public class MybatisPlusConfig {
    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //拦截器处理链
        List<ISqlParser> sqlParserList = new ArrayList<>();
        // 加入防止全表更新删除拦截器
        sqlParserList.add(new BlockAttackSqlParser());
        paginationInterceptor.setSqlParserList(sqlParserList);
        //导出数据时 500条限制问题
        paginationInterceptor.setLimit(Constant.MAX_PAGE_SIZE);
        return paginationInterceptor;
    }

    /***
     * 性能分析拦截器,开发环境使用
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        // SQL是否格式化 默认false
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
     * 使@version生效
     *
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }

    /**
     * 配置 Oracle jdbcTypeForNull允许null写入
     *
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            /**
             * 配置Oracle新增、修改操作时，jdbcTypeForNull允许null写入
             */
            @Override
            public void customize(Configuration configuration) {
                configuration.setJdbcTypeForNull(JdbcType.NULL);
            }
        };
    }
}

