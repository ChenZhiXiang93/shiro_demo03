package czx.wt;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("czx.wt.mapper")
public class ShiroDemo03Application {

    public static void main(String[] args) {
        SpringApplication.run(ShiroDemo03Application.class, args);
    }
}
