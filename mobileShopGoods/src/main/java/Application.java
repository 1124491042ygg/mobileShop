import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.mobile.mall.goods.db","com.mobile.mall.goods.db.controller","com.mobile.mall.goods.db.services"})
@MapperScan("com.mobile.mall.goods.db.dao")
@EnableTransactionManagement
@EnableScheduling
public class Application {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
