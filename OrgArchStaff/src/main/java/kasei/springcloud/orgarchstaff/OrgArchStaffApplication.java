package kasei.springcloud.orgarchstaff;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@MapperScan("kasei.springcloud.orgarchstaff.repository.dao")
public class OrgArchStaffApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrgArchStaffApplication.class, args);
    }
}
