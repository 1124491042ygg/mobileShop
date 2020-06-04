import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.mobile.mall.goods.db","com.mobile.mall.goods.controller","com.mobile.mall.goods.services"})
@MapperScan("com.mobile.mall.goods.db.dao")
@EnableTransactionManagement
@EnableScheduling
@ComponentScan({"com.mobile.mall.goods.config","com.mobile.mall.goods.controller","com.mobile.mall.goods.services","com.mobile.mall.utils.aop"})
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
