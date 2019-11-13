package kasei.springcloud.loginregister;

import kasei.springcloud.loginregister.config.OracleDataSourceConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication      // same as @Configuration @EnableAutoConfiguration @ComponentScan
@Import({OracleDataSourceConfig.class})
@MapperScan("kasei.springcloud.loginregister.repository.dao")
public class LoginRegisterApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginRegisterApplication.class, args);
    }
}

