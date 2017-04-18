package com.littlefisher.core.spring.config;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.filter.logging.Log4jFilter;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * 
 * Description: 
 *  
 * Created on 2017年4月18日 
 *
 * @author jinyanan
 * @version 1.0
 * @since v1.0
 */
@Configuration
public class DataSourceConfig {
    
    /**
     * url
     */
    @Value("${jdbc_url}")
    private String url;
    
    /**
     * userName
     */
    @Value("${jdbc_username}")
    private String userName;
    
    /**
     * password
     */
    @Value("${jdbc_password}")
    private String password;
    
    /**
     * validationQuerySQL
     */
    @Value("${validationQuery}")
    private String validationQuerySQL;

    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return DataSource
     * @throws SQLException 
     */
    @Bean(initMethod = "init", destroyMethod = "close")
    public DataSource dataSource() throws SQLException {
        DruidDataSource dataSource = new DruidDataSource();
//        基本属性 url、user、password
        dataSource.setUrl(url);
        dataSource.setUsername(userName);
        dataSource.setPassword(password);
//        配置初始化大小、最小、最大
        dataSource.setInitialSize(0);
        dataSource.setMaxActive(20);
//        最小连接池数量
        dataSource.setMinIdle(0);
//        配置获取连接等待超时的时间
        dataSource.setMaxWait(60000L);
//        用来检测连接是否有效的sql，要求是一个查询语句。
//        如果validationQuery为null，testOnBorrow、testOnReturn、testWhileIdle都不会其作用。
        dataSource.setValidationQuery(validationQuerySQL);
//        申请连接时执行validationQuery检测连接是否有效
//        做了这个配置会降低性能
        dataSource.setTestOnBorrow(false);
//        归还连接时执行validationQuery检测连接是否有效
//        做了这个配置会降低性能
        dataSource.setTestOnReturn(false);
//        建议配置为true，不影响性能，并且保证安全性
//        申请连接的时候检测，如果空闲时间大于
//        timeBetweenEvictionRunsMillis
//        执行validationQuery检测连接是否有效
        dataSource.setTestWhileIdle(true);
//        配置间隔多久才进行一次检测，检测需要关闭的空闲连接，单位是毫秒
        dataSource.setTimeBetweenEvictionRunsMillis(60000L);
//        配置一个连接在池中最小生存的时间，单位是毫秒
        dataSource.setMinEvictableIdleTimeMillis(25200000L);
//        对于长时间不使用的连接强制关闭
        dataSource.setRemoveAbandoned(true);
//        超过30分钟开始关闭空闲连接
        dataSource.setRemoveAbandonedTimeout(1800);
//        将当前关闭动作记录到日志
        dataSource.setLogAbandoned(true);
//        druid filters的别名保存在下面的地址中、
//        druid-xxx.jar!/META-INF/druid-filter.properties
        dataSource.setFilters("mergeStat");
//        配置log相关的信息
        List<Filter> filters = new ArrayList<>();
        filters.add(log4jFilter());
        dataSource.setProxyFilters(filters);
        return dataSource;
    }
    
    /**
     * 
     * Description: 
     * 
     * @author jinyanan
     *
     * @return Filter
     */
    @Bean
    public Filter log4jFilter() {
        Log4jFilter filter = new Log4jFilter();
//        打印可执行sql
        filter.setStatementExecutableSqlLogEnable(true);
        return filter;
    }
    
    
}
