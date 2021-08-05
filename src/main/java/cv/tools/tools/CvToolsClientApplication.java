package cv.tools.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })/**/
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CvToolsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvToolsClientApplication.class, args);
    }

}
