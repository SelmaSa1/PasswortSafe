package ch.bbw.passwortsafe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class PasswortSafeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswortSafeApplication.class, args);
	}

}
