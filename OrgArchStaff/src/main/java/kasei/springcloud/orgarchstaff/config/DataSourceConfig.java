package kasei.springcloud.orgarchstaff.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;


@Configuration

//@PropertySource("classpath:config/xxx.yml")  // 可能是个坑，因为在其他配置文件取了
public class DataSourceConfig {


    /** Spring 中 Bean 的名称详解
     * 1. @Component @Controller @Service @Repository 不添加 Bean 名时，注入的 Bean 名称为 类的首字母小写；可使用 @Controller("customBeanName") 自定义 Bean 名称
     * 2. 在 @Configuration 方法上使用，Bean 名称默认为 方法名，可使用 @Bean("customBeanName")
     * */
    // @Bean("mysqlDataSource")
    // @ConfigurationProperties("spring.datasource.mysql") // 配合 @Bean 使用表示将属性注入到该方法创建的实例中
    // @Primary
    // public DataSource mysqlDataSource() {
    //     return DataSourceBuilder.create().build();
    // }

    // @Bean
    // @ConfigurationProperties("spring.datasource.oracle")
    // public DataSource oracleDataSource(){
    //     return DataSourceBuilder.create().build();
    // }


}
