package SistemaSME;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@EntityScan(basePackages = "com.sliit.af")
public class SistemaSMEApplication {
    public static void main(String[] args) {
        SpringApplication.run(SistemaSMEApplication.class, args);
    }
}
